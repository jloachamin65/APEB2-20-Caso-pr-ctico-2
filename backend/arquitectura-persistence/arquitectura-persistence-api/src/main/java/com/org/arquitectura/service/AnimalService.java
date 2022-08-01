package com.org.arquitectura.service;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.Animal;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;

import java.util.Collection;

public interface AnimalService {

    PagedResult<Animal> listarPaginado(FilterParam filterParam) throws RefugioSearchException;

    void crearRegistro(Animal animal) throws RefugioPersistException;

    void eliminarRegistro(Animal animal) throws RefugioPersistException;

    Collection<Animal> listar() throws RefugioSearchException;

    void actualizarRegistro(Animal animal) throws RefugioPersistException;
}
