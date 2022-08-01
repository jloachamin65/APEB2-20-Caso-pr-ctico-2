package com.org.arquitectura;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.entities.Tipo;
import com.org.arquitectura.factory.ArquitecturaApplication;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;
import org.junit.Test;

public class TipoTestCliente {

    @Test
    public void listarInformacionPaginado() {
        PagedResult<Tipo> lista = null;
        FilterParam filterParam = new FilterParam();
        filterParam.setFirstResult(0);
        filterParam.setItemPerPage(5);
        try {
            lista = ArquitecturaApplication.getInstance().getTipoService().listarTipoPaginado(filterParam);
            for (Tipo r : lista.getItems()) {
                System.out.println(r.getCodigo() + " " + r.getNombre() + " " + r.getDescripcion());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void crearInfo() {
        Tipo tipo = new Tipo();
        tipo.setCodigo("MG");
        tipo.setNombre("GATO");
        tipo.setDescripcion("PARA DEFINIR UNA MASCOTA DE TIPO GATO");
        try {
            ArquitecturaApplication.getInstance().getTipoService().crearRegistro(tipo);

        } catch (RefugioPersistException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void eliminarInfo() {
        Tipo tipo = new Tipo();
        tipo.setCodigo("MG");
        tipo.setNombre("GATO");
        try {
            ArquitecturaApplication.getInstance().getTipoService().eliminarRegistro(tipo);

        } catch (RefugioPersistException e) {
            e.printStackTrace();
        }
    }
}
