package com.org.arquitectura.dao;

import com.org.arquitectura.HibernateRepository;
import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.Direccion;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

public class DireccionDaoImpl extends HibernateRepository implements DireccionDao {
    @Override
    public void crearRegistro(Direccion direccion) throws RefugioPersistException {
        getSession().persist(direccion);
    }

    @Override
    public void actualizarRegistro(Direccion direccion) throws RefugioPersistException {
        getSession().merge(direccion);
    }

    @Override
    public void eliminarRegistro(Direccion direccion) throws RefugioPersistException {
        getSession().delete(direccion);
    }

    @Override
    public Direccion buscarDireccionPorIdPersona(Integer id) throws RefugioSearchException {
        Criteria criteria = getSession().createCriteria(Direccion.class);
        criteria.createAlias("persona", "persona", JoinType.INNER_JOIN);
        criteria.add(Restrictions.eq("persona.idPersona", id));

        return (Direccion) criteria.uniqueResult();
    }
}
