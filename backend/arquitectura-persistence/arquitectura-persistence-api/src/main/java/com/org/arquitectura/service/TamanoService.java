package com.org.arquitectura.service;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.Tamano;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;

import java.util.Collection;

public interface TamanoService {

    PagedResult<Tamano> listarPaginado(FilterParam filterParam) throws RefugioSearchException;

    void crearRegistro(Tamano tamano) throws RefugioPersistException;

    void eliminarRegistro(Tamano tamano) throws RefugioPersistException;

    Collection<Tamano> listar() throws RefugioSearchException;
}
