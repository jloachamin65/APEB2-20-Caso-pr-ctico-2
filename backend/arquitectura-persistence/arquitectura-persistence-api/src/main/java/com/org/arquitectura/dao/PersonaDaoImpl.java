package com.org.arquitectura.dao;

import com.org.arquitectura.HibernateRepository;
import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.Persona;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.Collection;

public class PersonaDaoImpl extends HibernateRepository implements PersonaDao {
    @Override
    public Persona crearRegistro(Persona persona) throws RefugioPersistException {
         getSession().persist(persona);
        return persona;
    }

    @Override
    public void eliminarRegistro(Persona persona) throws RefugioPersistException {
        getSession().delete(persona);
    }

    @Override
    public Persona buscarPersonaPorId(Integer id) throws RefugioSearchException {
        Criteria criteria = getSession().createCriteria(Persona.class);
        criteria.add(Restrictions.eq("idPersona", id));

        return (Persona) criteria.uniqueResult();
    }

    @Override
    public Collection<Persona> listar() throws RefugioSearchException {
        Criteria criteria = getSession().createCriteria(Persona.class);
        return criteria.list();
    }
}
