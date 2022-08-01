package com.org.arquitectura.service;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.Rol;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;

import java.util.Collection;

public interface RolService {

    PagedResult<Rol> listarPaginado(FilterParam filterParam) throws RefugioSearchException;

    void crearRegistro(Rol rol) throws RefugioPersistException;

    void eliminarRegistro(Rol rol) throws RefugioPersistException;

    Collection<Rol> listar() throws RefugioSearchException;
}
