package com.org.arquitectura;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.Raza;
import com.org.arquitectura.entities.Tipo;
import com.org.arquitectura.factory.ArquitecturaFactory;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;
import org.junit.Test;

import java.util.Collection;

public class RazaTest {

    @Test
    public void listarRazaPaginado() {
        PagedResult<Raza> lista = null;
        FilterParam filterParam = new FilterParam();
        filterParam.setFirstResult(0);
        filterParam.setItemPerPage(3);
        try {
            lista = ArquitecturaFactory.getInstance().getRazaService().listarRazaPaginado(filterParam);
            for (Raza r : lista.getItems()) {
                System.out.println(r.getCodigo());
            }
        } catch (RefugioSearchException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void listar() {
        try {
            Collection<Raza> lista = null;
            lista = ArquitecturaFactory.getInstance().getRazaService().listarRaza();
            for (Raza r : lista) {
                System.out.println(r.getCodigo());
            }
        } catch (RefugioSearchException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void crearRaza() {
        Tipo tipo = new Tipo();
        Raza raza = new Raza();
        tipo.setIdTipo(2);
        tipo.setCodigo("MG");
        tipo.setNombre("GATO");
        tipo.setDescripcion("PARA DEFINIR UNA MASCOTA DE TIPO GATO");
        raza.setCodigo("AG");
        raza.setNombre("ANGORA");
        raza.setDescripcion("ANGORA");
        raza.setTipo(tipo);
        try {
            ArquitecturaFactory.getInstance().getRazaService().crearRegistro(raza);

        } catch (RefugioPersistException e) {
            e.printStackTrace();
        }
    }
}
