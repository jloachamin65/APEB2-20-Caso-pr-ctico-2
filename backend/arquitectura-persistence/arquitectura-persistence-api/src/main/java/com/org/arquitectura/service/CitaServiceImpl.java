package com.org.arquitectura.service;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.dao.CitaDao;
import com.org.arquitectura.entities.Cita;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;

import java.util.Collection;

public class CitaServiceImpl implements CitaService {

    private CitaDao citaDao;

    @Override
    public PagedResult<Cita> listarPaginado(FilterParam filterParam) throws RefugioSearchException {
        return citaDao.listarPaginado(filterParam);
    }

    @Override
    public void crearRegistro(Cita cita) throws RefugioPersistException {
        citaDao.crearRegistro(cita);
    }

    @Override
    public void eliminarRegistro(Cita cita) throws RefugioPersistException {
        citaDao.eliminarRegistro(cita);
    }

    @Override
    public Collection<Cita> listar() throws RefugioSearchException {
        return citaDao.listar();
    }

    public void setCitaDao(CitaDao citaDao) {
        this.citaDao = citaDao;
    }
}
