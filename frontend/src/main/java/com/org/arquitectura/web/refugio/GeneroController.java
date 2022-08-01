package com.org.arquitectura.web.refugio;

import com.org.arquitectura.entities.Genero;
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
public class GeneroController {

    @RequestMapping(value = "/listarGeneroPaginado_json", method = RequestMethod.POST)
    @ResponseBody
    public PagedResult listarGeneroPaginado(@RequestBody FilterParam filterParam, HttpSession session) throws Exception {
        PagedResult pagedResult = null;
        try {
            pagedResult = ArquitecturaApplication.getInstance().getGeneroService().listarPaginado(filterParam);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pagedResult;
    }

    @RequestMapping(value = "/registrarGenero_json", method = RequestMethod.POST)
    @ResponseBody
    public void registrarGenero(@RequestBody Genero genero, HttpSession session) throws Exception {

        ArquitecturaApplication.getInstance().getGeneroService().crearRegistro(genero);
    }

    @RequestMapping(value = "/eliminarGenero_json", method = RequestMethod.POST)
    @ResponseBody
    public void eliminarGenero(@RequestBody Genero genero, HttpSession session) throws Exception {

        ArquitecturaApplication.getInstance().getGeneroService().eliminarRegistro(genero);
    }

    @RequestMapping(value = "/listarGenero_json", method = RequestMethod.POST)
    @ResponseBody
    public Collection<Genero> listarGenero(HttpSession session) throws Exception {
        Collection<Genero> lista = null;
        try {
            lista = ArquitecturaApplication.getInstance().getGeneroService().listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
