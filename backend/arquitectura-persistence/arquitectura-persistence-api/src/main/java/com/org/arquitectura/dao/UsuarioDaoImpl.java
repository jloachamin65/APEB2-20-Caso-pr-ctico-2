package com.org.arquitectura.dao;

import com.org.arquitectura.HibernateRepository;
import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.Usuario;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import java.util.Collection;
import java.util.Map;

public class UsuarioDaoImpl extends HibernateRepository implements UsuarioDao {
    @Override
    public PagedResult<Usuario> listarPaginado(FilterParam filterParam) throws RefugioSearchException {
        PagedResult<Usuario> lista = null;
        Criteria criteriCount = getSession().createCriteria(Usuario.class);
        criteriCount = homologarPaginado(criteriCount, filterParam, false);

        try {
            Long numRows = (Long) criteriCount.setProjection(Projections.rowCount()).uniqueResult();
            if (numRows != null && numRows > 0) {
                lista = new PagedResult<Usuario>();
                Criteria criteria = getSession().createCriteria(Usuario.class);
                criteria = homologarPaginado(criteria, filterParam, true);

                criteria.setFirstResult(filterParam.getFirstResult());
                criteria.setMaxResults(filterParam.getItemPerPage());
                lista.setItems(criteria.list());
                lista.setTotalCount(numRows);
            }
        } catch (RefugioSearchException e) {
            e.printStackTrace();
            throw new RefugioSearchException("Error al ejeutar metodo lista", e);
        }

        return lista;
    }

    @Override
    public Criteria homologarPaginado(Criteria criteria, FilterParam filterParam, boolean applyOrder) throws RefugioSearchException {
        criteria.createAlias("rol", "rol", JoinType.INNER_JOIN);
        criteria.createAlias("persona", "persona", JoinType.INNER_JOIN);
        if (applyOrder) {
            if (filterParam.getOrderBy() == null) {
                criteria.addOrder(Order.asc("usuario"));
            } else {
                for (Map.Entry<String, String> entry : filterParam.getFilterByFields().entrySet()) {
                    criteria.addOrder("desc".equals(entry.getValue()) ? Order.desc(entry.getKey()) : Order.asc(entry.getKey()));
                }
            }
        }

        if (filterParam.getFilterByFields() != null) {
            for (Map.Entry<String, String> entry : filterParam.getFilterByFields().entrySet()) {
                if (entry.getValue() != null && !"".equals(entry.getValue())) {
                    criteria.add(Restrictions.ilike(entry.getKey(), entry.getValue().toString(), MatchMode.ANYWHERE));
                }

            }
        }
        return criteria;
    }

    @Override
    public Usuario crearRegistro(Usuario usuario) throws RefugioPersistException {
        getSession().persist(usuario);
        return usuario;
    }

    @Override
    public void eliminarRegistro(Usuario usuario) throws RefugioPersistException {
        getSession().delete(usuario);
    }

    @Override
    public Collection<Usuario> listar() throws RefugioSearchException {
        Criteria criteria = getSession().createCriteria(Usuario.class);
        criteria.createAlias("rol", "rol", JoinType.INNER_JOIN);
        criteria.createAlias("persona", "persona", JoinType.INNER_JOIN);
        return criteria.list();
    }
}
