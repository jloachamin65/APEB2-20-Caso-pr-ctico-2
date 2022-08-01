package com.org.arquitectura.service;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.dao.DireccionDao;
import com.org.arquitectura.entities.Direccion;

public class DireccionServiceImpl implements DireccionService {

    private DireccionDao direccionDao;

    @Override
    public void crearRegistro(Direccion direccion) throws RefugioPersistException {
        direccionDao.crearRegistro(direccion);
    }

    @Override
    public void actualizarRegistro(Direccion direccion) throws RefugioPersistException {
        direccionDao.actualizarRegistro(direccion);
    }

    @Override
    public void eliminarRegistro(Direccion direccion) throws RefugioPersistException {
        direccionDao.eliminarRegistro(direccion);
    }

    @Override
    public Direccion buscarDireccionPorIdPersona(Integer id) throws RefugioSearchException {
        return direccionDao.buscarDireccionPorIdPersona(id);
    }

    public void setDireccionDao(DireccionDao direccionDao) {
        this.direccionDao = direccionDao;
    }
}
