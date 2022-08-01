package com.org.arquitectura.service;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.dao.GeneroDao;
import com.org.arquitectura.entities.Genero;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;

import java.util.Collection;

public class GeneroServiceImpl implements GeneroService {

    private GeneroDao generoDao;

    @Override
    public PagedResult<Genero> listarPaginado(FilterParam filterParam) throws RefugioSearchException {
        return generoDao.listarPaginado(filterParam);
    }

    @Override
    public void crearRegistro(Genero genero) throws RefugioPersistException {
        generoDao.crearRegistro(genero);
    }

    @Override
    public void eliminarRegistro(Genero genero) throws RefugioPersistException {
        generoDao.eliminarRegistro(genero);
    }

    @Override
    public Collection<Genero> listar() throws RefugioSearchException {
        return generoDao.listar();
    }

    public void setGeneroDao(GeneroDao generoDao) {
        this.generoDao = generoDao;
    }
}
