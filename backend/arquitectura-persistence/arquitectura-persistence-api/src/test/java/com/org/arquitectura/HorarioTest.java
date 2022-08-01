package com.org.arquitectura;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.Genero;
import com.org.arquitectura.entities.Horario;
import com.org.arquitectura.factory.ArquitecturaFactory;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;
import org.junit.Test;

import java.util.Date;

public class HorarioTest {

    @Test
    public void listarPaginado() {
        PagedResult<Horario> lista = null;
        FilterParam filterParam = new FilterParam();
        filterParam.setFirstResult(0);
        filterParam.setItemPerPage(3);
        try {
            lista = ArquitecturaFactory.getInstance().getHorarioService().listarPaginado(filterParam);
            for (Horario r : lista.getItems()) {
                System.out.println(r.getCodigo());
            }
        } catch (RefugioSearchException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void crear() {
        Horario horario = new Horario();
        horario.setCodigo("H1");
        horario.setFecha(new Date());
        horario.setHora(8);
        horario.setEstado('D');
        horario.setDescripcion("DISPONIBLE");
        try {
            ArquitecturaFactory.getInstance().getHorarioService().crearRegistro(horario);

        } catch (RefugioPersistException e) {
            e.printStackTrace();
        }
    }
}
