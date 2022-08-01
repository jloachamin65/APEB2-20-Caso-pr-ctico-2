package com.org.arquitectura;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.Genero;
import com.org.arquitectura.factory.ArquitecturaFactory;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;
import org.junit.Test;

public class GeneroTest {

    @Test
    public void listarPaginado() {
        PagedResult<Genero> lista = null;
        FilterParam filterParam = new FilterParam();
        filterParam.setFirstResult(0);
        filterParam.setItemPerPage(3);
        try {
            lista = ArquitecturaFactory.getInstance().getGeneroService().listarPaginado(filterParam);
            for (Genero r : lista.getItems()) {
                System.out.println(r.getCodigo());
            }
        } catch (RefugioSearchException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void crear() {
        Genero genero = new Genero();
        genero.setCodigo('F');
        genero.setNombre("FEMENINO");
        try {
            ArquitecturaFactory.getInstance().getGeneroService().crearRegistro(genero);

        } catch (RefugioPersistException e) {
            e.printStackTrace();
        }
    }
}
