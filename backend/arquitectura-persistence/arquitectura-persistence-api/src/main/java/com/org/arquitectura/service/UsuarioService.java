package com.org.arquitectura.service;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.Usuario;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;

import java.util.Collection;

public interface UsuarioService {

    PagedResult<Usuario> listarPaginado(FilterParam filterParam) throws RefugioSearchException;

    Usuario crearRegistro(Usuario usuario) throws RefugioPersistException;

    void eliminarRegistro(Usuario usuario) throws RefugioPersistException;

    Collection<Usuario> listar() throws RefugioSearchException;
}
