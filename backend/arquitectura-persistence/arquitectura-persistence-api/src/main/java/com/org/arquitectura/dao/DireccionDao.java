package com.org.arquitectura.dao;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.Direccion;

public interface DireccionDao {

    void crearRegistro(Direccion direccion) throws RefugioPersistException;

    void actualizarRegistro(Direccion direccion) throws RefugioPersistException;

    void eliminarRegistro(Direccion direccion) throws RefugioPersistException;

    Direccion buscarDireccionPorIdPersona(Integer id) throws RefugioSearchException;
}
