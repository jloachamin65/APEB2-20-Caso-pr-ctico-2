package com.org.arquitectura;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.entities.*;
import com.org.arquitectura.factory.ArquitecturaFactory;
import org.junit.Test;

import java.util.Date;

public class EmpleadoTest {

    @Test
    public void crear() {
        //Persona
        Persona persona = new Persona();
        persona.setNombre("Karina");
        persona.setApellidoPaterno("Karmona");
        persona.setApellidoMaterno("Lopez");
        persona.setIdentificacion("12998322348");
        persona.setFechaNacimiento(new Date());
        persona.setDescripcion(" ");
        persona.setCorreo("kkarmona@gmail.com");
        //Genero
        Genero genero = new Genero();
        genero.setIdGenero(1);
        persona.setGenero(genero);

        try {
            //Insertar Persona
            Persona personaEncontrada;
            personaEncontrada = ArquitecturaFactory.getInstance().getPersonaService().crearRegistro(persona);
            //Direccion
            Direccion direccion = new Direccion();
            direccion.setCallePrincipal("Quito");
            direccion.setCalleSecundaria("Juan Pio Montufar");
            direccion.setNumeroCasa("S/N");
            direccion.setCelular("0987234532");
            direccion.setTelefono("022265212");
            direccion.setDescripcion(" ");
            direccion.setPersona(personaEncontrada);
            //Insertar Direccion
            ArquitecturaFactory.getInstance().getDireccionService().crearRegistro(direccion);

            Empleado empleado = new Empleado();
            empleado.setCodigo("EMP-00001");
            empleado.setCargo("ANALISTA TICS");
            empleado.setDescripcion("ANALISTA DEPARTAMENTO TICS ");
            empleado.setPersona(personaEncontrada);

            //Insertar Empleado
            ArquitecturaFactory.getInstance().getEmpleadoService().crearRegistro(empleado);

        } catch (RefugioPersistException e) {
            e.printStackTrace();
        }
    }
}
