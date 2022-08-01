package com.org.arquitectura.dao;

import com.org.arquitectura.HibernateRepository;
import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.Tipo;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.Collection;
import java.util.Map;

public class TipoDaoImpl extends HibernateRepository implements TipoDao {

    @Override
    public PagedResult<Tipo> listarTipoPaginado(FilterParam filterParam) throws RefugioSearchException {
        PagedResult<Tipo> listaTipo = null;
        Criteria criteriCount = getSession().createCriteria(Tipo.class);
        criteriCount = homologarTipoPaginado(criteriCount, filterParam, false);

        try {
            Long numRows = (Long) criteriCount.setProjection(Projections.rowCount()).uniqueResult();
            if (numRows != null && numRows > 0) {
                listaTipo = new PagedResult<Tipo>();
                Criteria criteria = getSession().createCriteria(Tipo.class);
                criteria = homologarTipoPaginado(criteria, filterParam, true);

                criteria.setFirstResult(filterParam.getFirstResult());
                criteria.setMaxResults(filterParam.getItemPerPage());
                listaTipo.setItems(criteria.list());
                listaTipo.setTotalCount(numRows);
            }
        } catch (RefugioSearchException e) {
            e.printStackTrace();
            throw new RefugioSearchException("Error al ejeutar metodo listaTipo", e);
        }

        return listaTipo;
    }

    @Override
    public Criteria homologarTipoPaginado(Criteria criteria, FilterParam filterParam, boolean applyOrder) throws RefugioSearchException {
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
    public void crearRegistro(Tipo tipo) throws RefugioPersistException {
        getSession().persist(tipo);
    }

    @Override
    public void eliminarRegistro(Tipo tipo) throws RefugioPersistException {
        getSession().delete(tipo);
    }

    @Override
    public Collection<Tipo> listarTipos() throws RefugioSearchException {
        Criteria criteria = getSession().createCriteria(Tipo.class);
        return criteria.list();
    }

}
