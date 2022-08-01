package com.org.arquitectura.dao;

import com.org.arquitectura.HibernateRepository;
import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.Cita;
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

public class CitaDaoImpl extends HibernateRepository implements CitaDao {
    @Override
    public PagedResult<Cita> listarPaginado(FilterParam filterParam) throws RefugioSearchException {
        PagedResult<Cita> lista = null;
        Criteria criteriCount = getSession().createCriteria(Cita.class);
        criteriCount = homologarPaginado(criteriCount, filterParam, false);

        try {
            Long numRows = (Long) criteriCount.setProjection(Projections.rowCount()).uniqueResult();
            if (numRows != null && numRows > 0) {
                lista = new PagedResult<Cita>();
                Criteria criteria = getSession().createCriteria(Cita.class);
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
        criteria.createAlias("usuario", "usuario", JoinType.INNER_JOIN);
        criteria.createAlias("empleadoHorario", "empleadoHorario", JoinType.INNER_JOIN);
        criteria.createAlias("animal", "animal", JoinType.INNER_JOIN);
        criteria.createAlias("usuario.persona", "usuario.persona", JoinType.INNER_JOIN);
        criteria.createAlias("usuario.rol", "usuario.rol", JoinType.INNER_JOIN);
        criteria.createAlias("empleadoHorario.empleado", "empleadoHorario.empleado", JoinType.INNER_JOIN);
        criteria.createAlias("empleadoHorario.empleado.persona", "empleadoHorario.empleado.persona", JoinType.INNER_JOIN);
        criteria.createAlias("empleadoHorario.horario", "empleadoHorario.horario", JoinType.INNER_JOIN);
        criteria.createAlias("animal.raza", "animal.raza", JoinType.INNER_JOIN);
        criteria.createAlias("animal.color", "animal.color", JoinType.INNER_JOIN);
        criteria.createAlias("animal.tamano", "animal.tamano", JoinType.INNER_JOIN);
        criteria.createAlias("animal.situacion", "animal.situacion", JoinType.INNER_JOIN);
        criteria.createAlias("animal.estado", "animal.estado", JoinType.INNER_JOIN);
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
    public void crearRegistro(Cita cita) throws RefugioPersistException {
        getSession().persist(cita);
    }

    @Override
    public void eliminarRegistro(Cita cita) throws RefugioPersistException {
        getSession().delete(cita);
    }

    @Override
    public Collection<Cita> listar() throws RefugioSearchException {
        Criteria criteria = getSession().createCriteria(Cita.class);
        criteria.createAlias("usuario", "usuario", JoinType.INNER_JOIN);
        criteria.createAlias("empleadoHorario", "empleadoHorario", JoinType.INNER_JOIN);
        criteria.createAlias("animal", "animal", JoinType.INNER_JOIN);
        criteria.createAlias("usuario.persona", "usuario.persona", JoinType.INNER_JOIN);
        criteria.createAlias("usuario.rol", "usuario.rol", JoinType.INNER_JOIN);
        criteria.createAlias("empleadoHorario.empleado", "empleadoHorario.empleado", JoinType.INNER_JOIN);
        criteria.createAlias("empleadoHorario.empleado.persona", "empleadoHorario.empleado.persona", JoinType.INNER_JOIN);
        criteria.createAlias("empleadoHorario.horario", "empleadoHorario.horario", JoinType.INNER_JOIN);
        criteria.createAlias("animal.raza", "animal.raza", JoinType.INNER_JOIN);
        criteria.createAlias("animal.color", "animal.color", JoinType.INNER_JOIN);
        criteria.createAlias("animal.tamano", "animal.tamano", JoinType.INNER_JOIN);
        criteria.createAlias("animal.situacion", "animal.situacion", JoinType.INNER_JOIN);
        criteria.createAlias("animal.estado", "animal.estado", JoinType.INNER_JOIN);
        return criteria.list();
    }
}
