package com.org.arquitectura.service;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.dao.EmpleadoHorarioDao;
import com.org.arquitectura.entities.EmpleadoHorario;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;

import java.util.Collection;

public class EmpleadoHorarioServiceImpl implements EmpleadoHorarioService {

    private EmpleadoHorarioDao empleadoHorarioDao;

    @Override
    public PagedResult<EmpleadoHorario> listarPaginado(FilterParam filterParam) throws RefugioSearchException {
        return empleadoHorarioDao.listarPaginado(filterParam);
    }

    @Override
    public void crearRegistro(EmpleadoHorario empleadoHorario) throws RefugioPersistException {
        empleadoHorarioDao.crearRegistro(empleadoHorario);
    }

    @Override
    public void eliminarRegistro(EmpleadoHorario empleadoHorario) throws RefugioPersistException {
        empleadoHorarioDao.eliminarRegistro(empleadoHorario);
    }

    @Override
    public Collection<EmpleadoHorario> listar() throws RefugioSearchException {
        return empleadoHorarioDao.listar();
    }

    public void setEmpleadoHorarioDao(EmpleadoHorarioDao empleadoHorarioDao) {
        this.empleadoHorarioDao = empleadoHorarioDao;
    }
}
