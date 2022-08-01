package com.org.arquitectura.dao;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.Usuario;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;
import org.hibernate.Criteria;

import java.util.Collection;

public interface UsuarioDao {

    PagedResult<Usuario> listarPaginado(FilterParam filterParam) throws RefugioSearchException;

    Criteria homologarPaginado(Criteria criteria, FilterParam filterParam, boolean applyOrder) throws RefugioSearchException;

    Usuario crearRegistro(Usuario usuario) throws RefugioPersistException;

    void eliminarRegistro(Usuario usuario) throws RefugioPersistException;

    Collection<Usuario> listar() throws RefugioSearchException;
}
