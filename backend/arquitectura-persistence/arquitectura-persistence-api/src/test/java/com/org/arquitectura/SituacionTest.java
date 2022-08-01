package com.org.arquitectura;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.Situacion;
import com.org.arquitectura.factory.ArquitecturaFactory;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;
import org.junit.Test;

public class SituacionTest {

    @Test
    public void listarPaginado() {
        PagedResult<Situacion> lista = null;
        FilterParam filterParam = new FilterParam();
        filterParam.setFirstResult(0);
        filterParam.setItemPerPage(3);
        try {
            lista = ArquitecturaFactory.getInstance().getSituacionService().listarPaginado(filterParam);
            for (Situacion r : lista.getItems()) {
                System.out.println(r.getCodigo());
            }
        } catch (RefugioSearchException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void crear() {
        Situacion situacion = new Situacion();
        situacion.setCodigo("D");
        situacion.setSituacion("DISPONIBLE");
        situacion.setDescripcion("PERFECTO ESTADO PARA SER ADOPTADO");
        try {
            ArquitecturaFactory.getInstance().getSituacionService().crearRegistro(situacion);

        } catch (RefugioPersistException e) {
            e.printStackTrace();
        }
    }
}
