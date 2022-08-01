package com.org.arquitectura;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.entities.*;
import com.org.arquitectura.factory.ArquitecturaFactory;
import org.junit.Test;

import java.util.Date;

public class CitaTest {

    @Test
    public void crear() {
        //Persona
        Persona persona = new Persona();
        persona.setNombre("Monica");
        persona.setApellidoPaterno("Teran");
        persona.setApellidoMaterno("Lopez");
        persona.setIdentificacion("12998822348");
        persona.setFechaNacimiento(new Date());
        persona.setDescripcion(" ");
        persona.setCorreo("mteran@gmail.com");
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
            usuario.setUsuario("mteran");
            usuario.setClave("123456");

            Rol rol = new Rol();
            rol.setIdRol(1);

            usuario.setRol(rol);
            usuario.setPersona(personaEncontrada);

            //Insertar Usuario
            Usuario usuarioInsertado;
            usuarioInsertado = ArquitecturaFactory.getInstance().getUsuarioService().crearRegistro(usuario);

            //Buscar Animal
            Animal animal = new Animal();
            animal.setIdAnimal(1);

            //Buscar horario
            EmpleadoHorario empleadoHorario = new EmpleadoHorario();
            empleadoHorario.setIdEmpleadoHorario(1);

            //Insertar Cita
            Cita cita = new Cita();
            cita.setCodigo("C-00001");
            cita.setFecha(new Date());
            cita.setEstado('A');
            cita.setDescripcion("AGENDADO");
            cita.setAnimal(animal);
            cita.setUsuario(usuarioInsertado);
            cita.setEmpleadoHorario(empleadoHorario);
            ArquitecturaFactory.getInstance().getCitaService().crearRegistro(cita);

        } catch (RefugioPersistException e) {
            e.printStackTrace();
        }
    }
}
