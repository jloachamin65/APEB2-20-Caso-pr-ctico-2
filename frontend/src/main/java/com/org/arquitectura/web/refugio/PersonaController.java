package com.org.arquitectura.web.refugio;

import com.org.arquitectura.entities.Persona;
import com.org.arquitectura.factory.ArquitecturaApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class PersonaController {

    @RequestMapping(value = "/registrarPersona_json", method = RequestMethod.POST)
    @ResponseBody
    public Persona registrarPersona(@RequestBody Persona persona, HttpSession session) throws Exception {
        Persona personaRequest;
        personaRequest = ArquitecturaApplication.getInstance().getPersonaService().crearRegistro(persona);
        return personaRequest;
    }

    @RequestMapping(value = "/eliminarPersona_json", method = RequestMethod.POST)
    @ResponseBody
    public void eliminarPersona(@RequestBody Persona persona, HttpSession session) throws Exception {

        ArquitecturaApplication.getInstance().getPersonaService().eliminarRegistro(persona);
    }

    @RequestMapping(value = "/listarPersona_json", method = RequestMethod.POST)
    @ResponseBody
    public Collection<Persona> listarPersona(HttpSession session) throws Exception {
        Collection<Persona> lista = null;
        try {
            lista = ArquitecturaApplication.getInstance().getPersonaService().listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    @RequestMapping(value = "/buscarPersonaPorIdPersona_json", method = RequestMethod.POST)
    @ResponseBody
    public Persona buscarPersonaPorIdPersona(@RequestBody Integer idPersona, HttpSession session) throws Exception {
        Persona persona = null;
        try {
            persona = ArquitecturaApplication.getInstance().getPersonaService().buscarPersonaPorId(idPersona);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return persona;
    }
}


