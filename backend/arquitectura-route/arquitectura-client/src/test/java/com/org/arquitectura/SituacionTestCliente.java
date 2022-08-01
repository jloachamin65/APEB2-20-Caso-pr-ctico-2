package com.org.arquitectura;

import com.org.arquitectura.entities.Situacion;
import com.org.arquitectura.factory.ArquitecturaApplication;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;
import org.junit.Test;

public class SituacionTestCliente {

    @Test
    public void listarPaginado() {
        PagedResult<Situacion> lista = null;
        FilterParam filterParam = new FilterParam();
        filterParam.setFirstResult(0);
        filterParam.setItemPerPage(5);
        try {
            lista = ArquitecturaApplication.getInstance().getSituacionService().listarPaginado(filterParam);
            for (Situacion r : lista.getItems()) {
                System.out.println(r.getCodigo() + " " + r.getSituacion());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
