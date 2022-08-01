package com.org.arquitectura.service;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.dao.PersonaDao;
import com.org.arquitectura.entities.Persona;

import java.util.Collection;

public class PersonaServiceImpl implements PersonaService {

    private PersonaDao personaDao;

    @Override
    public Persona crearRegistro(Persona persona) throws RefugioPersistException {
        return personaDao.crearRegistro(persona);
    }

    @Override
    public void eliminarRegistro(Persona persona) throws RefugioPersistException {
        personaDao.eliminarRegistro(persona);
    }

    @Override
    public Persona buscarPersonaPorId(Integer id) throws RefugioSearchException {
        return personaDao.buscarPersonaPorId(id);
    }

    @Override
    public Collection<Persona> listar() throws RefugioSearchException {
        return personaDao.listar();
    }

    public void setPersonaDao(PersonaDao personaDao) {
        this.personaDao = personaDao;
    }
}
