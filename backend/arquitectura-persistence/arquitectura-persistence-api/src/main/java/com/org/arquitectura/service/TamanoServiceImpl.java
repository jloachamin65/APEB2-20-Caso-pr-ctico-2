package com.org.arquitectura.service;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.dao.TamanoDao;
import com.org.arquitectura.entities.Tamano;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;

import java.util.Collection;

public class TamanoServiceImpl implements TamanoService {

    private TamanoDao tamanoDao;

    @Override
    public PagedResult<Tamano> listarPaginado(FilterParam filterParam) throws RefugioSearchException {
        return tamanoDao.listarPaginado(filterParam);
    }

    @Override
    public void crearRegistro(Tamano tamano) throws RefugioPersistException {
        tamanoDao.crearRegistro(tamano);
    }

    @Override
    public void eliminarRegistro(Tamano tamano) throws RefugioPersistException {
        tamanoDao.eliminarRegistro(tamano);
    }

    @Override
    public Collection<Tamano> listar() throws RefugioSearchException {
        return tamanoDao.listar();
    }

    public void setTamanoDao(TamanoDao tamanoDao) {
        this.tamanoDao = tamanoDao;
    }
}
