package com.org.arquitectura.service;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.dao.HorarioDao;
import com.org.arquitectura.entities.Horario;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;

import java.util.Collection;

public class HorarioServiceImpl implements HorarioService {

    private HorarioDao horarioDao;

    @Override
    public PagedResult<Horario> listarPaginado(FilterParam filterParam) throws RefugioSearchException {
        return horarioDao.listarPaginado(filterParam);
    }

    @Override
    public void crearRegistro(Horario horario) throws RefugioPersistException {
        horarioDao.crearRegistro(horario);
    }

    @Override
    public void eliminarRegistro(Horario horario) throws RefugioPersistException {
        horarioDao.eliminarRegistro(horario);
    }

    @Override
    public Collection<Horario> listar() throws RefugioSearchException {
        return horarioDao.listar();
    }

    public void setHorarioDao(HorarioDao horarioDao) {
        this.horarioDao = horarioDao;
    }
}
