package com.org.arquitectura;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.Estado;
import com.org.arquitectura.factory.ArquitecturaFactory;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;
import org.junit.Test;

public class EstadoTest {

    @Test
    public void listarPaginado() {
        PagedResult<Estado> lista = null;
        FilterParam filterParam = new FilterParam();
        filterParam.setFirstResult(0);
        filterParam.setItemPerPage(3);
        try {
            lista = ArquitecturaFactory.getInstance().getEstadoService().listarPaginado(filterParam);
            for (Estado r : lista.getItems()) {
                System.out.println(r.getCodigo());
            }
        } catch (RefugioSearchException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void crear() {
        Estado estado = new Estado();
        estado.setCodigo("S");
        estado.setEstado("SANO");
        estado.setDescripcion("PERFECTO ESTADO");
        try {
            ArquitecturaFactory.getInstance().getEstadoService().crearRegistro(estado);

        } catch (RefugioPersistException e) {
            e.printStackTrace();
        }
    }
}
