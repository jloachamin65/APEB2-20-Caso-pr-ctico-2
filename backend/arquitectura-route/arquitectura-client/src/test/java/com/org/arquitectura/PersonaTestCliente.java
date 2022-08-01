package com.org.arquitectura;

import com.org.arquitectura.entities.Persona;
import com.org.arquitectura.factory.ArquitecturaApplication;
import org.junit.Test;

import java.util.Collection;

public class PersonaTestCliente {

    @Test
    public void listar() {
        Collection<Persona> lista = null;
        try {
            lista = ArquitecturaApplication.getInstance().getPersonaService().listar();
            for (Persona r : lista) {
                System.out.println(r.getNombre() + " " + r.getApellidoPaterno());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
