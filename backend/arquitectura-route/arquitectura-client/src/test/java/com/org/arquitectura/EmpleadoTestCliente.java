package com.org.arquitectura;

import com.org.arquitectura.entities.Empleado;
import com.org.arquitectura.factory.ArquitecturaApplication;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;
import org.junit.Test;

import java.util.Collection;

public class EmpleadoTestCliente {

    @Test
    public void listar() {
        Collection<Empleado> lista = null;
        try {
            lista = ArquitecturaApplication.getInstance().getEmpleadoService().listar();
            for (Empleado r : lista) {
                System.out.println(r.getCodigo() + " " + r.getCargo()+ " " +
                        r.getPersona().getNombre()+ " " +
                        r.getPersona().getIdentificacion()+ " " +
                        r.getPersona().getCorreo()+ " " +
                        r.getPersona().getFechaNacimiento());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void listarPaginado() {
        PagedResult<Empleado> lista = null;
        FilterParam filterParam = new FilterParam();
        filterParam.setFirstResult(0);
        filterParam.setItemPerPage(5);
        try {
            lista = ArquitecturaApplication.getInstance().getEmpleadoService().listarPaginado(filterParam);
            for (Empleado r : lista.getItems()) {
                System.out.println(r.getCodigo() + " " + r.getPersona().getNombre());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
