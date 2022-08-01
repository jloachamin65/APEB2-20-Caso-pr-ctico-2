package com.org.arquitectura;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.Empleado;
import com.org.arquitectura.entities.EmpleadoHorario;
import com.org.arquitectura.entities.Horario;
import com.org.arquitectura.factory.ArquitecturaFactory;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;
import org.junit.Test;

import java.util.Collection;

public class EmpleadoHorarioTest {

    @Test
    public void crear() {
        EmpleadoHorario empleadoHorario = new EmpleadoHorario();
        empleadoHorario.setDescripcion("TARDE");
        empleadoHorario.setEstado('D');

        Horario horario = new Horario();
        horario.setIdHorario(4);

        empleadoHorario.setHorario(horario);

        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(3);

        empleadoHorario.setEmpleado(empleado);

        try {
            ArquitecturaFactory.getInstance().getEmpleadoHorarioService().crearRegistro(empleadoHorario);

        } catch (RefugioPersistException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void listarPaginado() {
        PagedResult<EmpleadoHorario> lista = null;
        FilterParam filterParam = new FilterParam();
        filterParam.setFirstResult(0);
        filterParam.setItemPerPage(3);
        try {
            lista = ArquitecturaFactory.getInstance().getEmpleadoHorarioService().listarPaginado(filterParam);
            for (EmpleadoHorario r : lista.getItems()) {
                System.out.println(r.getDescripcion());
            }
        } catch (RefugioSearchException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void listar() {
        Collection<EmpleadoHorario> lista = null;
        try {
            lista = ArquitecturaFactory.getInstance().getEmpleadoHorarioService().listar();
            for (EmpleadoHorario r : lista) {
                System.out.println(r.getDescripcion());
            }
        } catch (RefugioSearchException e) {
            e.printStackTrace();
        }
    }
}
