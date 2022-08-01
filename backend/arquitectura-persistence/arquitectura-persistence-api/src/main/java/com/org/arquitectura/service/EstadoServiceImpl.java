package com.org.arquitectura.service;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.dao.EstadoDao;
import com.org.arquitectura.entities.Estado;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;

import java.util.Collection;

public class EstadoServiceImpl implements EstadoService {

    private EstadoDao estadoDao;

    @Override
    public PagedResult<Estado> listarPaginado(FilterParam filterParam) throws RefugioSearchException {
        return estadoDao.listarPaginado(filterParam);
    }

    @Override
    public void crearRegistro(Estado estado) throws RefugioPersistException {
        estadoDao.crearRegistro(estado);
    }

    @Override
    public void eliminarRegistro(Estado estado) throws RefugioPersistException {
        estadoDao.eliminarRegistro(estado);
    }

    @Override
    public Collection<Estado> listar() throws RefugioSearchException {
        return estadoDao.listar();
    }

    public void setEstadoDao(EstadoDao estadoDao) {
        this.estadoDao = estadoDao;
    }
}
