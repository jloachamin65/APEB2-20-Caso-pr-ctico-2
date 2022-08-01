package com.org.arquitectura;

import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.Direccion;
import com.org.arquitectura.factory.ArquitecturaFactory;
import org.junit.Test;

public class DireccionTest {

    @Test
    public void obtenerDireccionPorIdPersona() {
        Direccion direccion;
        try {
            direccion = ArquitecturaFactory.getInstance().getDireccionService().buscarDireccionPorIdPersona(4);
            System.out.println(direccion.getCallePrincipal() + " " +
                    direccion.getCalleSecundaria() + " " +
                    direccion.getPersona().getNombre() + " " + direccion.getPersona().getIdentificacion());

        } catch (RefugioSearchException e) {
            e.printStackTrace();
        }
    }
}
