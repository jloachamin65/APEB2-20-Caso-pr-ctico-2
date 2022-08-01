package com.org.arquitectura;

import com.org.arquitectura.entities.EmpleadoHorario;
import com.org.arquitectura.factory.ArquitecturaApplication;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;
import org.junit.Test;

public class EmpleadoHorarioTestCliente {

    @Test
    public void listarPaginado() {
        PagedResult<EmpleadoHorario> lista = null;
        FilterParam filterParam = new FilterParam();
        filterParam.setFirstResult(0);
        filterParam.setItemPerPage(5);
        try {
            lista = ArquitecturaApplication.getInstance().getEmpleadoHorarioService().listarPaginado(filterParam);
            for (EmpleadoHorario r : lista.getItems()) {
                System.out.println(r.getDescripcion() + " " + r.getEmpleado().getPersona().getNombre());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
