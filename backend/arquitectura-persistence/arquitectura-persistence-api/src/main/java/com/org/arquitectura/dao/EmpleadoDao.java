package com.org.arquitectura.dao;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.Empleado;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;
import org.hibernate.Criteria;

import java.util.Collection;

public interface EmpleadoDao {

    PagedResult<Empleado> listarPaginado(FilterParam filterParam) throws RefugioSearchException;

    Criteria homologarPaginado(Criteria criteria, FilterParam filterParam, boolean applyOrder) throws RefugioSearchException;

    void crearRegistro(Empleado empleado) throws RefugioPersistException;

    void eliminarRegistro(Empleado empleado) throws RefugioPersistException;

    Collection<Empleado> listar() throws RefugioSearchException;
}
