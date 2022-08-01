package com.org.arquitectura.web.refugio;

import com.org.arquitectura.entities.Estado;
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
public class EstadoController {
    @RequestMapping(value = "/listarEstadoPaginado_json", method = RequestMethod.POST)
    @ResponseBody
    public PagedResult listarEstadoPaginado(@RequestBody FilterParam filterParam, HttpSession session) throws Exception {
        PagedResult pagedResult = null;
        try {
            pagedResult = ArquitecturaApplication.getInstance().getEstadoService().listarPaginado(filterParam);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pagedResult;
    }

    @RequestMapping(value = "/registrarEstado_json", method = RequestMethod.POST)
    @ResponseBody
    public void registrarEstado(@RequestBody Estado estado, HttpSession session) throws Exception {

        ArquitecturaApplication.getInstance().getEstadoService().crearRegistro(estado);
    }

    @RequestMapping(value = "/eliminarEstado_json", method = RequestMethod.POST)
    @ResponseBody
    public void eliminarEstado(@RequestBody Estado estado, HttpSession session) throws Exception {

        ArquitecturaApplication.getInstance().getEstadoService().eliminarRegistro(estado);
    }

    @RequestMapping(value = "/listarEstado_json", method = RequestMethod.POST)
    @ResponseBody
    public Collection<Estado> listarEstado(HttpSession session) throws Exception {
        Collection<Estado> lista = null;
        try {
            lista = ArquitecturaApplication.getInstance().getEstadoService().listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
