package com.org.arquitectura.web.refugio;

import com.org.arquitectura.entities.Color;
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
public class ColorController {

    @RequestMapping(value = "/listarColorPaginado_json", method = RequestMethod.POST)
    @ResponseBody
    public PagedResult listarColorPaginado(@RequestBody FilterParam filterParam, HttpSession session) throws Exception {
        PagedResult pagedResult = null;
        try {
            pagedResult = ArquitecturaApplication.getInstance().getColorService().listarPaginado(filterParam);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pagedResult;
    }

    @RequestMapping(value = "/registrarColor_json", method = RequestMethod.POST)
    @ResponseBody
    public void registrarColor(@RequestBody Color color, HttpSession session) throws Exception {

        ArquitecturaApplication.getInstance().getColorService().crearRegistro(color);
    }

    @RequestMapping(value = "/eliminarColor_json", method = RequestMethod.POST)
    @ResponseBody
    public void eliminarColor(@RequestBody Color color, HttpSession session) throws Exception {

        ArquitecturaApplication.getInstance().getColorService().eliminarRegistro(color);
    }

    @RequestMapping(value = "/listarColor_json", method = RequestMethod.POST)
    @ResponseBody
    public Collection<Color> listarColor(HttpSession session) throws Exception {
        Collection<Color> lista = null;
        try {
            lista = ArquitecturaApplication.getInstance().getColorService().listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
