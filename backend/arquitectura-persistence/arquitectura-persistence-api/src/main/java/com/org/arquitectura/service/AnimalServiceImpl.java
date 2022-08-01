package com.org.arquitectura.service;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.dao.AnimalDao;
import com.org.arquitectura.entities.Animal;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;

import java.util.Collection;

public class AnimalServiceImpl implements AnimalService {

    private AnimalDao animalDao;

    @Override
    public PagedResult<Animal> listarPaginado(FilterParam filterParam) throws RefugioSearchException {
        return animalDao.listarPaginado(filterParam);
    }

    @Override
    public void crearRegistro(Animal animal) throws RefugioPersistException {
        animalDao.crearRegistro(animal);
    }

    @Override
    public void eliminarRegistro(Animal animal) throws RefugioPersistException {
        animalDao.eliminarRegistro(animal);
    }

    @Override
    public Collection<Animal> listar() throws RefugioSearchException {
        return animalDao.listar();
    }

    @Override
    public void actualizarRegistro(Animal animal) throws RefugioPersistException {
        animalDao.actualizarRegistro(animal);
    }

    public void setAnimalDao(AnimalDao animalDao) {
        this.animalDao = animalDao;
    }
}
