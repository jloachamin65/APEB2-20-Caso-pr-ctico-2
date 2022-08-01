package com.org.arquitectura.web.refugio;

import com.org.arquitectura.entities.Direccion;
import com.org.arquitectura.factory.ArquitecturaApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class DireccionController {

    @RequestMapping(value = "/registrarDireccion_json", method = RequestMethod.POST)
    @ResponseBody
    public void registrarDireccion(@RequestBody Direccion direccion, HttpSession session) throws Exception {

        ArquitecturaApplication.getInstance().getDireccionService().crearRegistro(direccion);
    }

    @RequestMapping(value = "/eliminarDireccion_json", method = RequestMethod.POST)
    @ResponseBody
    public void eliminarDireccion(@RequestBody Direccion direccion, HttpSession session) throws Exception {

        ArquitecturaApplication.getInstance().getDireccionService().eliminarRegistro(direccion);
    }

    @RequestMapping(value = "/buscarDireccionPorIdPersona_json", method = RequestMethod.POST)
    @ResponseBody
    public Direccion buscarDireccionPorIdPersona(@RequestBody Integer idPersona, HttpSession session) throws Exception {
        Direccion direccion = null;
        try {
            direccion = ArquitecturaApplication.getInstance().getDireccionService().buscarDireccionPorIdPersona(idPersona);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return direccion;
    }

    @RequestMapping(value = "/actualizarDireccion_json", method = RequestMethod.POST)
    @ResponseBody
    public void actualizarDireccion(@RequestBody Direccion direccion, HttpSession session) throws Exception {

        ArquitecturaApplication.getInstance().getDireccionService().actualizarRegistro(direccion);
    }
}
