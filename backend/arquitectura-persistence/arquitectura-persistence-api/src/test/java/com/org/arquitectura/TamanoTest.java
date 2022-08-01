package com.org.arquitectura;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.Tamano;
import com.org.arquitectura.factory.ArquitecturaFactory;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;
import org.junit.Test;

public class TamanoTest {

    @Test
    public void listarPaginado() {
        PagedResult<Tamano> lista = null;
        FilterParam filterParam = new FilterParam();
        filterParam.setFirstResult(0);
        filterParam.setItemPerPage(3);
        try {
            lista = ArquitecturaFactory.getInstance().getTamanoService().listarPaginado(filterParam);
            for (Tamano r : lista.getItems()) {
                System.out.println(r.getCodigo());
            }
        } catch (RefugioSearchException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void crear() {
        Tamano tamano = new Tamano();
        tamano.setCodigo("G");
        tamano.setNombre("GRANDE");
        try {
            ArquitecturaFactory.getInstance().getTamanoService().crearRegistro(tamano);

        } catch (RefugioPersistException e) {
            e.printStackTrace();
        }
    }
}
