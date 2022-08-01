package com.org.arquitectura;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.Tipo;
import com.org.arquitectura.factory.ArquitecturaFactory;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;
import org.junit.Test;

import java.util.Collection;

public class TipoTest {

    @Test
    public void listarTipoPaginado() {
        PagedResult<Tipo> lista = null;
        FilterParam filterParam = new FilterParam();
        filterParam.setFirstResult(0);
        filterParam.setItemPerPage(3);
        try {
            lista = ArquitecturaFactory.getInstance().getTipoService().listarTipoPaginado(filterParam);
            for (Tipo r : lista.getItems()) {
                System.out.println(r.getCodigo());
            }
        } catch (RefugioSearchException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void listarTipos() {
        try {
            Collection<Tipo> lista = null;
            lista = ArquitecturaFactory.getInstance().getTipoService().listarTipos();
            for (Tipo r : lista) {
                System.out.println(r.getCodigo());
            }
        } catch (RefugioSearchException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void crearTipo() {
        Tipo tipo = new Tipo();
        tipo.setCodigo("MG");
        tipo.setNombre("GATO");
        tipo.setDescripcion("PARA DEFINIR UNA MASCOTA DE TIPO GATO");
        try {
            ArquitecturaFactory.getInstance().getTipoService().crearRegistro(tipo);

        } catch (RefugioPersistException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void eliminarInfo() {
        Tipo tipo = new Tipo();
        tipo.setCodigo("MG");
        tipo.setNombre("GATO");
        try {
            ArquitecturaFactory.getInstance().getTipoService().eliminarRegistro(tipo);

        } catch (RefugioPersistException e) {
            e.printStackTrace();
        }
    }
}
