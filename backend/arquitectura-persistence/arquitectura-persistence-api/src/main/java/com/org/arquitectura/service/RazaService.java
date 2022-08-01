package com.org.arquitectura.service;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.Raza;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;

import java.util.Collection;

public interface RazaService {

    PagedResult<Raza> listarRazaPaginado(FilterParam filterParam) throws RefugioSearchException;

    void crearRegistro(Raza raza) throws RefugioPersistException;

    void eliminarRegistro(Raza raza) throws RefugioPersistException;

    Collection<Raza> listarRaza() throws RefugioSearchException;
}
