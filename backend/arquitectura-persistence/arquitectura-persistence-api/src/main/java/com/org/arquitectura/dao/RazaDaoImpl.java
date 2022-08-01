package com.org.arquitectura.dao;

import com.org.arquitectura.HibernateRepository;
import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.Raza;
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

public class RazaDaoImpl extends HibernateRepository implements RazaDao {
    @Override
    public PagedResult<Raza> listarRazaPaginado(FilterParam filterParam) throws RefugioSearchException {
        PagedResult<Raza> listaRaza = null;
        Criteria criteriCount = getSession().createCriteria(Raza.class);
        criteriCount = homologarRazaPaginado(criteriCount, filterParam, false);

        try {
            Long numRows = (Long) criteriCount.setProjection(Projections.rowCount()).uniqueResult();
            if (numRows != null && numRows > 0) {
                listaRaza = new PagedResult<Raza>();
                Criteria criteria = getSession().createCriteria(Raza.class);
                criteria = homologarRazaPaginado(criteria, filterParam, true);

                criteria.setFirstResult(filterParam.getFirstResult());
                criteria.setMaxResults(filterParam.getItemPerPage());
                listaRaza.setItems(criteria.list());
                listaRaza.setTotalCount(numRows);
            }
        } catch (RefugioSearchException e) {
            e.printStackTrace();
            throw new RefugioSearchException("Error al ejeutar metodo listaRaza", e);
        }

        return listaRaza;
    }

    @Override
    public Criteria homologarRazaPaginado(Criteria criteria, FilterParam filterParam, boolean applyOrder) throws RefugioSearchException {
        criteria.createAlias("tipo", "tipo", JoinType.INNER_JOIN);
        if (applyOrder) {
            if (filterParam.getOrderBy() == null) {
                criteria.addOrder(Order.asc("codigo"));
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
    public void crearRegistro(Raza raza) throws RefugioPersistException {
        getSession().persist(raza);

    }

    @Override
    public void eliminarRegistro(Raza raza) throws RefugioPersistException {
        getSession().delete(raza);
    }

    @Override
    public Collection<Raza> listarRaza() throws RefugioSearchException {
        Criteria criteria = getSession().createCriteria(Raza.class);
        criteria.createAlias("tipo", "tipo", JoinType.INNER_JOIN);
        return criteria.list();
    }
}
