package com.org.arquitectura;

import com.org.arquitectura.entities.Animal;
import com.org.arquitectura.factory.ArquitecturaApplication;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;
import org.junit.Test;

public class AnimalTestCliente {

    @Test
    public void listarPaginado() {
        PagedResult<Animal> lista = null;
        FilterParam filterParam = new FilterParam();
        filterParam.setFirstResult(0);
        filterParam.setItemPerPage(5);
        try {
            lista = ArquitecturaApplication.getInstance().getAnimalService().listarPaginado(filterParam);
            for (Animal r : lista.getItems()) {
                System.out.println(r.getCodigo() + " " +
                        r.getNombre() + " " +
                        r.getDescripcion() + " " +
                        r.getRaza().getNombre() + " " +
                        r.getColor().getNombre() + " " +
                        r.getTamano().getNombre() + " " +
                        r.getSituacion().getSituacion() + " " +
                        r.getEstado().getEstado());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
