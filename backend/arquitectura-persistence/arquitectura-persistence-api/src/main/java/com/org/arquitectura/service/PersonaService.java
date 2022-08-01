package com.org.arquitectura.service;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.Persona;

import java.util.Collection;

public interface PersonaService {

    Persona crearRegistro(Persona persona) throws RefugioPersistException;

    void eliminarRegistro(Persona persona) throws RefugioPersistException;

    Persona buscarPersonaPorId(Integer id) throws RefugioSearchException;

    Collection<Persona> listar() throws RefugioSearchException;
}
