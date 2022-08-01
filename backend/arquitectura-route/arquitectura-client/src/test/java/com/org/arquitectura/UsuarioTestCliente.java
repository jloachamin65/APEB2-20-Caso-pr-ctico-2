package com.org.arquitectura;

import com.org.arquitectura.entities.Usuario;
import com.org.arquitectura.factory.ArquitecturaApplication;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;
import org.junit.Test;

public class UsuarioTestCliente {

    @Test
    public void listarPaginado() {
        PagedResult<Usuario> lista = null;
        FilterParam filterParam = new FilterParam();
        filterParam.setFirstResult(0);
        filterParam.setItemPerPage(5);
        try {
            lista = ArquitecturaApplication.getInstance().getUsuarioService().listarPaginado(filterParam);
            for (Usuario r : lista.getItems()) {
                System.out.println(r.getUsuario() + " " +
                        r.getClave() + " " +
                        r.getPersona().getNombre() + " " + r.getPersona().getApellidoPaterno() + " " + r.getPersona().getIdentificacion() + " " +
                        r.getRol().getNombre());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
