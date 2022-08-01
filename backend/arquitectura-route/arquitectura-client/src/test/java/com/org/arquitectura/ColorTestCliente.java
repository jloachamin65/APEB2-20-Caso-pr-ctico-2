package com.org.arquitectura;

import com.org.arquitectura.entities.Color;
import com.org.arquitectura.factory.ArquitecturaApplication;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;
import org.junit.Test;

public class ColorTestCliente {

    @Test
    public void listarPaginado() {
        PagedResult<Color> lista = null;
        FilterParam filterParam = new FilterParam();
        filterParam.setFirstResult(0);
        filterParam.setItemPerPage(5);
        try {
            lista = ArquitecturaApplication.getInstance().getColorService().listarPaginado(filterParam);
            for (Color r : lista.getItems()) {
                System.out.println(r.getCodigo() + " " + r.getNombre());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
