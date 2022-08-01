package com.org.arquitectura;

import com.org.arquitectura.entities.Raza;
import com.org.arquitectura.factory.ArquitecturaApplication;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;
import org.junit.Test;

public class RazaTestCliente {

    @Test
    public void listarPaginado() {
        PagedResult<Raza> lista = null;
        FilterParam filterParam = new FilterParam();
        filterParam.setFirstResult(0);
        filterParam.setItemPerPage(5);
        try {
            lista = ArquitecturaApplication.getInstance().getRazaService().listarRazaPaginado(filterParam);
            for (Raza r : lista.getItems()) {
                System.out.println(r.getCodigo() + " " + r.getNombre() + " " + r.getDescripcion()+" "+r.getTipo().getNombre());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
