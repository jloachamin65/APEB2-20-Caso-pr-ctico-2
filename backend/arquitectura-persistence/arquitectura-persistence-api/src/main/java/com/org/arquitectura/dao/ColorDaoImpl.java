package com.org.arquitectura.dao;

import com.org.arquitectura.HibernateRepository;
import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.Color;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.Collection;
import java.util.Map;

public class ColorDaoImpl extends HibernateRepository implements ColorDao {
    @Override
    public PagedResult<Color> listarPaginado(FilterParam filterParam) throws RefugioSearchException {
        PagedResult<Color> lista = null;
        Criteria criteriCount = getSession().createCriteria(Color.class);
        criteriCount = homologarPaginado(criteriCount, filterParam, false);

        try {
            Long numRows = (Long) criteriCount.setProjection(Projections.rowCount()).uniqueResult();
            if (numRows != null && numRows > 0) {
                lista = new PagedResult<Color>();
                Criteria criteria = getSession().createCriteria(Color.class);
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
    public void crearRegistro(Color color) throws RefugioPersistException {
        getSession().persist(color);
    }

    @Override
    public void eliminarRegistro(Color color) throws RefugioPersistException {
        getSession().delete(color);
    }

    @Override
    public Collection<Color> listar() throws RefugioSearchException {
        Criteria criteria = getSession().createCriteria(Color.class);
        return criteria.list();
    }
}
