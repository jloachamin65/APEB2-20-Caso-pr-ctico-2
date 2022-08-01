package com.org.arquitectura.service;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.Estado;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;

import java.util.Collection;

public interface EstadoService {

    PagedResult<Estado> listarPaginado(FilterParam filterParam) throws RefugioSearchException;

    void crearRegistro(Estado estado) throws RefugioPersistException;

    void eliminarRegistro(Estado estado) throws RefugioPersistException;

    Collection<Estado> listar() throws RefugioSearchException;
}
