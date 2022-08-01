package com.org.arquitectura.service;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.dao.TipoDao;
import com.org.arquitectura.entities.Tipo;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;

import java.util.Collection;

public class TipoServiceImpl implements TipoService {

    private TipoDao tipoDao;

    @Override
    public PagedResult<Tipo> listarTipoPaginado(FilterParam filterParam) throws RefugioSearchException {
        return tipoDao.listarTipoPaginado(filterParam);
    }

    @Override
    public void crearRegistro(Tipo tipo) throws RefugioPersistException {
        tipoDao.crearRegistro(tipo);
    }

    @Override
    public void eliminarRegistro(Tipo tipo) throws RefugioPersistException {
        tipoDao.eliminarRegistro(tipo);
    }

    @Override
    public Collection<Tipo> listarTipos() throws RefugioSearchException {
        return tipoDao.listarTipos();
    }

    public void setTipoDao(TipoDao tipoDao) {
        this.tipoDao = tipoDao;
    }
}
