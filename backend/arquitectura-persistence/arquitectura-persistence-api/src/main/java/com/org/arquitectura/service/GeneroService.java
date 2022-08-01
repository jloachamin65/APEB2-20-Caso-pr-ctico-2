package com.org.arquitectura.service;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.Genero;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;

import java.util.Collection;

public interface GeneroService {

    PagedResult<Genero> listarPaginado(FilterParam filterParam) throws RefugioSearchException;

    void crearRegistro(Genero genero) throws RefugioPersistException;

    void eliminarRegistro(Genero genero) throws RefugioPersistException;

    Collection<Genero> listar() throws RefugioSearchException;
}
