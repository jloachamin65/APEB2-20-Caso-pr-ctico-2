package com.org.arquitectura.dao;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.Genero;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;
import org.hibernate.Criteria;

import java.util.Collection;

public interface GeneroDao {

    PagedResult<Genero> listarPaginado(FilterParam filterParam) throws RefugioSearchException;

    Criteria homologarPaginado(Criteria criteria, FilterParam filterParam, boolean applyOrder) throws RefugioSearchException;

    void crearRegistro(Genero genero) throws RefugioPersistException;

    void eliminarRegistro(Genero genero) throws RefugioPersistException;

    Collection<Genero> listar() throws RefugioSearchException;
}
