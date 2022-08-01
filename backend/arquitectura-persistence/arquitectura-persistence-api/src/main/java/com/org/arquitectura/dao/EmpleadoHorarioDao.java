package com.org.arquitectura.dao;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.EmpleadoHorario;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;
import org.hibernate.Criteria;

import java.util.Collection;

public interface EmpleadoHorarioDao {

    PagedResult<EmpleadoHorario> listarPaginado(FilterParam filterParam) throws RefugioSearchException;

    Criteria homologarPaginado(Criteria criteria, FilterParam filterParam, boolean applyOrder) throws RefugioSearchException;

    void crearRegistro(EmpleadoHorario empleadoHorario) throws RefugioPersistException;

    void eliminarRegistro(EmpleadoHorario empleadoHorario) throws RefugioPersistException;

    Collection<EmpleadoHorario> listar() throws RefugioSearchException;
}
