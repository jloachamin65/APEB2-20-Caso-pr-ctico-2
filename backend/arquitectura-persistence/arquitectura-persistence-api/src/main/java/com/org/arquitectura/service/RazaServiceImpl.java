package com.org.arquitectura.service;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.dao.RazaDao;
import com.org.arquitectura.entities.Raza;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;

import java.util.Collection;

public class RazaServiceImpl implements RazaService {

    private RazaDao razaDao;

    @Override
    public PagedResult<Raza> listarRazaPaginado(FilterParam filterParam) throws RefugioSearchException {
        return razaDao.listarRazaPaginado(filterParam);
    }

    @Override
    public void crearRegistro(Raza raza) throws RefugioPersistException {
        razaDao.crearRegistro(raza);
    }

    @Override
    public void eliminarRegistro(Raza raza) throws RefugioPersistException {
        razaDao.eliminarRegistro(raza);
    }

    @Override
    public Collection<Raza> listarRaza() throws RefugioSearchException {
        return razaDao.listarRaza();
    }

    public void setRazaDao(RazaDao razaDao) {
        this.razaDao = razaDao;
    }
}
