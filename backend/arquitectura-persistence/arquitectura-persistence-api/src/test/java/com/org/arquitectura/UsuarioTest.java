package com.org.arquitectura;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.entities.*;
import com.org.arquitectura.factory.ArquitecturaFactory;
import org.junit.Test;

import java.util.Date;

public class UsuarioTest {

    @Test
    public void crear() {
        //Persona
        Persona persona = new Persona();
        persona.setNombre("Luis");
        persona.setApellidoPaterno("Perez");
        persona.setApellidoMaterno("Lopez");
        persona.setIdentificacion("12998822348");
        persona.setFechaNacimiento(new Date());
        persona.setDescripcion(" ");
        persona.setCorreo("lperez@gmail.com");
        //Genero
        Genero genero = new Genero();
        genero.setIdGenero(4);
        persona.setGenero(genero);

        try {
            //Insertar Persona
            Persona personaEncontrada;
            personaEncontrada = ArquitecturaFactory.getInstance().getPersonaService().crearRegistro(persona);
            //Direccion
            Direccion direccion = new Direccion();
            direccion.setCallePrincipal("Ruminahui");
            direccion.setCalleSecundaria("Juan leon");
            direccion.setNumeroCasa("S/N");
            direccion.setCelular("0987654532");
            direccion.setTelefono("022065212");
            direccion.setDescripcion(" ");
            direccion.setPersona(personaEncontrada);
            //Insertar Direccion
            ArquitecturaFactory.getInstance().getDireccionService().crearRegistro(direccion);

            Usuario usuario = new Usuario();
            usuario.setUsuario("lperez");
            usuario.setClave("123456");

            Rol rol = new Rol();
            rol.setIdRol(1);

            usuario.setRol(rol);
            usuario.setPersona(personaEncontrada);

            //Insertar Usuario
            ArquitecturaFactory.getInstance().getUsuarioService().crearRegistro(usuario);

        } catch (RefugioPersistException e) {
            e.printStackTrace();
        }
    }
}
