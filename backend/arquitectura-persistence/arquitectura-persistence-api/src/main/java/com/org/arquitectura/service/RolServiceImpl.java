package com.org.arquitectura.service;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.dao.RolDao;
import com.org.arquitectura.entities.Rol;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;

import java.util.Collection;

public class RolServiceImpl implements RolService {

    private RolDao rolDao;

    @Override
    public PagedResult<Rol> listarPaginado(FilterParam filterParam) throws RefugioSearchException {
        return rolDao.listarPaginado(filterParam);
    }

    @Override
    public void crearRegistro(Rol rol) throws RefugioPersistException {
        rolDao.crearRegistro(rol);
    }

    @Override
    public void eliminarRegistro(Rol rol) throws RefugioPersistException {
        rolDao.eliminarRegistro(rol);
    }

    @Override
    public Collection<Rol> listar() throws RefugioSearchException {
        return rolDao.listar();
    }

    public void setRolDao(RolDao rolDao) {
        this.rolDao = rolDao;
    }
}
