package com.org.arquitectura;

import com.org.arquitectura.entities.Cita;
import com.org.arquitectura.factory.ArquitecturaApplication;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;
import org.junit.Test;

public class CitaTestCliente {

    @Test
    public void listarPaginado() {
        PagedResult<Cita> lista = null;
        FilterParam filterParam = new FilterParam();
        filterParam.setFirstResult(0);
        filterParam.setItemPerPage(5);
        try {
            lista = ArquitecturaApplication.getInstance().getCitaService().listarPaginado(filterParam);
            for (Cita r : lista.getItems()) {
                System.out.println(r.getCodigo() + " " + r.getDescripcion() + " " +
                        r.getAnimal().getNombre() + " " +
                        r.getEmpleadoHorario().getEmpleado().getPersona().getNombre() + " " +
                        r.getAnimal().getSituacion().getSituacion());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
