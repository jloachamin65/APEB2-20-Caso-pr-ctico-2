package com.org.arquitectura.service;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.Horario;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;

import java.util.Collection;

public interface HorarioService {

    PagedResult<Horario> listarPaginado(FilterParam filterParam) throws RefugioSearchException;

    void crearRegistro(Horario horario) throws RefugioPersistException;

    void eliminarRegistro(Horario horario) throws RefugioPersistException;

    Collection<Horario> listar() throws RefugioSearchException;
}
