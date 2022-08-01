package com.org.arquitectura.service;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.dao.EmpleadoDao;
import com.org.arquitectura.entities.Empleado;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;

import java.util.Collection;

public class EmpleadoServiceImpl implements EmpleadoService {
    private EmpleadoDao empleadoDao;

    @Override
    public PagedResult<Empleado> listarPaginado(FilterParam filterParam) throws RefugioSearchException {
        return empleadoDao.listarPaginado(filterParam);
    }

    @Override
    public void crearRegistro(Empleado empleado) throws RefugioPersistException {
        empleadoDao.crearRegistro(empleado);
    }

    @Override
    public void eliminarRegistro(Empleado empleado) throws RefugioPersistException {
        empleadoDao.eliminarRegistro(empleado);
    }

    @Override
    public Collection<Empleado> listar() throws RefugioSearchException {
        return empleadoDao.listar();
    }

    public void setEmpleadoDao(EmpleadoDao empleadoDao) {
        this.empleadoDao = empleadoDao;
    }
}
