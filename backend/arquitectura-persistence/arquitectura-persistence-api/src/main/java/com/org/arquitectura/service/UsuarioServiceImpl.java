package com.org.arquitectura.service;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.dao.UsuarioDao;
import com.org.arquitectura.entities.Usuario;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;

import java.util.Collection;

public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioDao usuarioDao;

    @Override
    public PagedResult<Usuario> listarPaginado(FilterParam filterParam) throws RefugioSearchException {
        return usuarioDao.listarPaginado(filterParam);
    }

    @Override
    public Usuario crearRegistro(Usuario usuario) throws RefugioPersistException {
        return usuarioDao.crearRegistro(usuario);
    }

    @Override
    public void eliminarRegistro(Usuario usuario) throws RefugioPersistException {
        usuarioDao.eliminarRegistro(usuario);
    }

    @Override
    public Collection<Usuario> listar() throws RefugioSearchException {
        return usuarioDao.listar();
    }

    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }
}
