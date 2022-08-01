package com.org.arquitectura.service;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.Situacion;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;

import java.util.Collection;

public interface SituacionService {

    PagedResult<Situacion> listarPaginado(FilterParam filterParam) throws RefugioSearchException;

    void crearRegistro(Situacion situacion) throws RefugioPersistException;

    void eliminarRegistro(Situacion situacion) throws RefugioPersistException;

    Collection<Situacion> listar() throws RefugioSearchException;
}
