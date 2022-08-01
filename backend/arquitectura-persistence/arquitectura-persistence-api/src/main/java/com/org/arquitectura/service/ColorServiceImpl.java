package com.org.arquitectura.service;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.dao.ColorDao;
import com.org.arquitectura.entities.Color;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;

import java.util.Collection;

public class ColorServiceImpl implements ColorService {

    private ColorDao colorDao;

    @Override
    public PagedResult<Color> listarPaginado(FilterParam filterParam) throws RefugioSearchException {
        return colorDao.listarPaginado(filterParam);
    }

    @Override
    public void crearRegistro(Color color) throws RefugioPersistException {
        colorDao.crearRegistro(color);
    }

    @Override
    public void eliminarRegistro(Color color) throws RefugioPersistException {
        colorDao.eliminarRegistro(color);
    }

    @Override
    public Collection<Color> listar() throws RefugioSearchException {
        return colorDao.listar();
    }

    public void setColorDao(ColorDao colorDao) {
        this.colorDao = colorDao;
    }
}
