package com.org.arquitectura.web.refugio;

import com.org.arquitectura.entities.Situacion;
import com.org.arquitectura.factory.ArquitecturaApplication;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class SituacionController {
    @RequestMapping(value = "/listarSituacionPaginado_json", method = RequestMethod.POST)
    @ResponseBody
    public PagedResult listarSituacionPaginado(@RequestBody FilterParam filterParam, HttpSession session) throws Exception {
        PagedResult pagedResult = null;
        try {
            pagedResult = ArquitecturaApplication.getInstance().getSituacionService().listarPaginado(filterParam);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pagedResult;
    }

    @RequestMapping(value = "/registrarSituacion_json", method = RequestMethod.POST)
    @ResponseBody
    public void registrarSituacion(@RequestBody Situacion situacion, HttpSession session) throws Exception {

        ArquitecturaApplication.getInstance().getSituacionService().crearRegistro(situacion);
    }

    @RequestMapping(value = "/eliminarSituacion_json", method = RequestMethod.POST)
    @ResponseBody
    public void eliminarSituacion(@RequestBody Situacion situacion, HttpSession session) throws Exception {

        ArquitecturaApplication.getInstance().getSituacionService().eliminarRegistro(situacion);
    }

    @RequestMapping(value = "/listarSituacion_json", method = RequestMethod.POST)
    @ResponseBody
    public Collection<Situacion> listarSituacion(HttpSession session) throws Exception {
        Collection<Situacion> lista = null;
        try {
            lista = ArquitecturaApplication.getInstance().getSituacionService().listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
