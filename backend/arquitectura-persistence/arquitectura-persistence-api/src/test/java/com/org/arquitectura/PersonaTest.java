package com.org.arquitectura;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.Genero;
import com.org.arquitectura.entities.Persona;
import com.org.arquitectura.factory.ArquitecturaFactory;
import org.junit.Test;

import java.util.Collection;
import java.util.Date;

public class PersonaTest {

    @Test
    public void listarPaginado() {
        Collection<Persona> lista = null;
        try {
            lista = ArquitecturaFactory.getInstance().getPersonaService().listar();
            for (Persona r : lista) {
                System.out.println(r.getNombre());
            }
        } catch (RefugioSearchException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void crear() {
        Persona persona = new Persona();
        persona.setNombre("Pablo Anibal");
        persona.setApellidoPaterno("Gomez");
        persona.setApellidoMaterno("Pachacama");
        persona.setIdentificacion("1722786341");
        persona.setFechaNacimiento(new Date());
        persona.setDescripcion(" ");
        persona.setCorreo("pgomez@gmail.com");
        Genero genero = new Genero();
        genero.setIdGenero(4);
        persona.setGenero(genero);

        Persona personaRetorno;
        try {
            personaRetorno = ArquitecturaFactory.getInstance().getPersonaService().crearRegistro(persona);
            System.out.println(personaRetorno.getNombre()+" "+personaRetorno.getApellidoMaterno());

        } catch (RefugioPersistException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void obtenerPersonaPorId(){
        Persona persona;
        try {
            persona = ArquitecturaFactory.getInstance().getPersonaService().buscarPersonaPorId(1);
            System.out.println(persona.getNombre()+" "+persona.getApellidoMaterno());

        } catch (RefugioSearchException e) {
            e.printStackTrace();
        }
    }
}
