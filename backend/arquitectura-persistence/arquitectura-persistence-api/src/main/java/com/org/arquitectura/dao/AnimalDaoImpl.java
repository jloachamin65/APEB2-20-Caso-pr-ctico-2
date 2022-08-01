package com.org.arquitectura.dao;

import com.org.arquitectura.HibernateRepository;
import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.Animal;
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

public class AnimalDaoImpl extends HibernateRepository implements AnimalDao {
    @Override
    public PagedResult<Animal> listarPaginado(FilterParam filterParam) throws RefugioSearchException {
        PagedResult<Animal> lista = null;
        Criteria criteriCount = getSession().createCriteria(Animal.class);
        criteriCount = homologarPaginado(criteriCount, filterParam, false);

        try {
            Long numRows = (Long) criteriCount.setProjection(Projections.rowCount()).uniqueResult();
            if (numRows != null && numRows > 0) {
                lista = new PagedResult<Animal>();
                Criteria criteria = getSession().createCriteria(Animal.class);
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
        criteria.createAlias("raza", "raza", JoinType.INNER_JOIN);
        criteria.createAlias("raza.tipo", "tipo", JoinType.INNER_JOIN);
        criteria.createAlias("color", "color", JoinType.INNER_JOIN);
        criteria.createAlias("tamano", "tamano", JoinType.INNER_JOIN);
        criteria.createAlias("situacion", "situacion", JoinType.INNER_JOIN);
        criteria.createAlias("estado", "estado", JoinType.INNER_JOIN);
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
    public void crearRegistro(Animal animal) throws RefugioPersistException {
        getSession().persist(animal);
    }

    @Override
    public void eliminarRegistro(Animal animal) throws RefugioPersistException {
        getSession().delete(animal);
    }

    @Override
    public Collection<Animal> listar() throws RefugioSearchException {
        Criteria criteria = getSession().createCriteria(Animal.class);
        criteria.createAlias("raza", "raza", JoinType.INNER_JOIN);
        criteria.createAlias("color", "color", JoinType.INNER_JOIN);
        criteria.createAlias("tamano", "tamano", JoinType.INNER_JOIN);
        criteria.createAlias("situacion", "situacion", JoinType.INNER_JOIN);
        criteria.createAlias("estado", "estado", JoinType.INNER_JOIN);
        return criteria.list();
    }

    @Override
    public void actualizarRegistro(Animal animal) throws RefugioPersistException {
        getSession().merge(animal);
    }
}
