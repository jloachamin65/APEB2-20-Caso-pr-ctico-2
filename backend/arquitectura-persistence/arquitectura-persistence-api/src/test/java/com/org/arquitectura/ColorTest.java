package com.org.arquitectura;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.Color;
import com.org.arquitectura.factory.ArquitecturaFactory;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;
import org.junit.Test;

public class ColorTest {

    @Test
    public void listarPaginado() {
        PagedResult<Color> lista = null;
        FilterParam filterParam = new FilterParam();
        filterParam.setFirstResult(0);
        filterParam.setItemPerPage(3);
        try {
            lista = ArquitecturaFactory.getInstance().getColorService().listarPaginado(filterParam);
            for (Color r : lista.getItems()) {
                System.out.println(r.getCodigo());
            }
        } catch (RefugioSearchException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void crear() {
        Color color = new Color();
        color.setCodigo("AZ");
        color.setNombre("AZUL");
        try {
            ArquitecturaFactory.getInstance().getColorService().crearRegistro(color);

        } catch (RefugioPersistException e) {
            e.printStackTrace();
        }
    }
}
