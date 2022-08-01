package com.org.arquitectura;

import com.org.arquitectura.entities.Horario;
import com.org.arquitectura.factory.ArquitecturaApplication;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;
import org.junit.Test;

public class HorarioTestCliente {

    @Test
    public void listarPaginado() {
        PagedResult<Horario> lista = null;
        FilterParam filterParam = new FilterParam();
        filterParam.setFirstResult(0);
        filterParam.setItemPerPage(5);
        try {
            lista = ArquitecturaApplication.getInstance().getHorarioService().listarPaginado(filterParam);
            for (Horario r : lista.getItems()) {
                System.out.println(r.getCodigo() + " " + r.getDescripcion());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
