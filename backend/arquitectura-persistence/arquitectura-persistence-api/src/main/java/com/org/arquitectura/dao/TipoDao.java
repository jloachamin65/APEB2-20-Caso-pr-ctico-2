package com.org.arquitectura.dao;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.Tipo;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;
import org.hibernate.Criteria;

import java.util.Collection;

public interface TipoDao {

    PagedResult<Tipo> listarTipoPaginado(FilterParam filterParam) throws RefugioSearchException;

    Criteria homologarTipoPaginado(Criteria criteria, FilterParam filterParam, boolean applyOrder) throws RefugioSearchException;

    void crearRegistro(Tipo tipo) throws RefugioPersistException;

    void eliminarRegistro(Tipo tipo) throws RefugioPersistException;

    Collection<Tipo> listarTipos() throws RefugioSearchException;
}
