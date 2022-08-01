package com.org.arquitectura.service;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.Empleado;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;

import java.util.Collection;

public interface EmpleadoService {

    PagedResult<Empleado> listarPaginado(FilterParam filterParam) throws RefugioSearchException;

    void crearRegistro(Empleado empleado) throws RefugioPersistException;

    void eliminarRegistro(Empleado empleado) throws RefugioPersistException;

    Collection<Empleado> listar() throws RefugioSearchException;
}
