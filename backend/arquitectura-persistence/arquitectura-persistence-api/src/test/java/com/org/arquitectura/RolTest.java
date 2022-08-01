package com.org.arquitectura;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.Rol;
import com.org.arquitectura.factory.ArquitecturaFactory;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;
import org.junit.Test;

public class RolTest {

    @Test
    public void listarPaginado() {
        PagedResult<Rol> lista = null;
        FilterParam filterParam = new FilterParam();
        filterParam.setFirstResult(0);
        filterParam.setItemPerPage(3);
        try {
            lista = ArquitecturaFactory.getInstance().getRolService().listarPaginado(filterParam);
            for (Rol r : lista.getItems()) {
                System.out.println(r.getCodigo());
            }
        } catch (RefugioSearchException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void crear() {
        Rol rol = new Rol();
        rol.setCodigo("AD");
        rol.setNombre("ADMINISTRADOR");
        rol.setDescripcion("ACCESO A TODA LA PALICACION");
        try {
            ArquitecturaFactory.getInstance().getRolService().crearRegistro(rol);

        } catch (RefugioPersistException e) {
            e.printStackTrace();
        }
    }
}
