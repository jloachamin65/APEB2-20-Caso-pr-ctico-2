package com.org.arquitectura.service;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.dao.SituacionDao;
import com.org.arquitectura.entities.Situacion;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;

import java.util.Collection;

public class SituacionServiceImpl implements SituacionService {

    private SituacionDao situacionDao;

    @Override
    public PagedResult<Situacion> listarPaginado(FilterParam filterParam) throws RefugioSearchException {
        return situacionDao.listarPaginado(filterParam);
    }

    @Override
    public void crearRegistro(Situacion situacion) throws RefugioPersistException {
        situacionDao.crearRegistro(situacion);
    }

    @Override
    public void eliminarRegistro(Situacion situacion) throws RefugioPersistException {
        situacionDao.eliminarRegistro(situacion);
    }

    @Override
    public Collection<Situacion> listar() throws RefugioSearchException {
        return situacionDao.listar();
    }

    public void setSituacionDao(SituacionDao situacionDao) {
        this.situacionDao = situacionDao;
    }
}
