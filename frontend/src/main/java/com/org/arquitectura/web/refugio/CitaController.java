package com.org.arquitectura.web.refugio;

import com.org.arquitectura.entities.Cita;
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
public class CitaController {

    @RequestMapping(value = "/listarCitaPaginado_json", method = RequestMethod.POST)
    @ResponseBody
    public PagedResult listarCitaPaginado(@RequestBody FilterParam filterParam, HttpSession session) throws Exception {
        PagedResult pagedResult = null;
        try {
            pagedResult = ArquitecturaApplication.getInstance().getCitaService().listarPaginado(filterParam);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pagedResult;
    }

    @RequestMapping(value = "/registrarCita_json", method = RequestMethod.POST)
    @ResponseBody
    public void registrarCita(@RequestBody Cita cita, HttpSession session) throws Exception {

        ArquitecturaApplication.getInstance().getCitaService().crearRegistro(cita);
    }

    @RequestMapping(value = "/eliminarCita_json", method = RequestMethod.POST)
    @ResponseBody
    public void eliminarCita(@RequestBody Cita cita, HttpSession session) throws Exception {

        ArquitecturaApplication.getInstance().getCitaService().eliminarRegistro(cita);
    }

    @RequestMapping(value = "/listarCita_json", method = RequestMethod.POST)
    @ResponseBody
    public Collection<Cita> listarCita(HttpSession session) throws Exception {
        Collection<Cita> lista = null;
        try {
            lista = ArquitecturaApplication.getInstance().getCitaService().listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
