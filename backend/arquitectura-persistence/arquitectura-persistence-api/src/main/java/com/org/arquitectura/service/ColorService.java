package com.org.arquitectura.service;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.Color;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;

import java.util.Collection;

public interface ColorService {

    PagedResult<Color> listarPaginado(FilterParam filterParam) throws RefugioSearchException;

    void crearRegistro(Color color) throws RefugioPersistException;

    void eliminarRegistro(Color color) throws RefugioPersistException;

    Collection<Color> listar() throws RefugioSearchException;
}
