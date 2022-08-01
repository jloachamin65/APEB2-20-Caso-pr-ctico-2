package com.org.arquitectura;

import com.org.arquitectura.entities.Genero;
import com.org.arquitectura.factory.ArquitecturaApplication;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;
import org.junit.Test;

public class GeneroTestCliente {

    @Test
    public void listarPaginado() {
        PagedResult<Genero> lista = null;
        FilterParam filterParam = new FilterParam();
        filterParam.setFirstResult(0);
        filterParam.setItemPerPage(5);
        try {
            lista = ArquitecturaApplication.getInstance().getGeneroService().listarPaginado(filterParam);
            for (Genero r : lista.getItems()) {
                System.out.println(r.getCodigo() + " " + r.getNombre());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
