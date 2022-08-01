package com.org.arquitectura.service;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.Cita;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;

import java.util.Collection;

public interface CitaService {

    PagedResult<Cita> listarPaginado(FilterParam filterParam) throws RefugioSearchException;

    void crearRegistro(Cita cita) throws RefugioPersistException;

    void eliminarRegistro(Cita cita) throws RefugioPersistException;

    Collection<Cita> listar() throws RefugioSearchException;
}
