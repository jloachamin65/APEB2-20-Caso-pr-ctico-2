package com.org.arquitectura.web.refugio;

import com.org.arquitectura.entities.Tamano;
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
public class TamanoController {
    @RequestMapping(value = "/listarTamanoPaginado_json", method = RequestMethod.POST)
    @ResponseBody
    public PagedResult listarTamanoPaginado(@RequestBody FilterParam filterParam, HttpSession session) throws Exception {
        PagedResult pagedResult = null;
        try {
            pagedResult = ArquitecturaApplication.getInstance().getTamanoService().listarPaginado(filterParam);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pagedResult;
    }

    @RequestMapping(value = "/registrarTamano_json", method = RequestMethod.POST)
    @ResponseBody
    public void registrarTamano(@RequestBody Tamano tamano, HttpSession session) throws Exception {

        ArquitecturaApplication.getInstance().getTamanoService().crearRegistro(tamano);
    }

    @RequestMapping(value = "/eliminarTamano_json", method = RequestMethod.POST)
    @ResponseBody
    public void eliminarTamano(@RequestBody Tamano tamano, HttpSession session) throws Exception {

        ArquitecturaApplication.getInstance().getTamanoService().eliminarRegistro(tamano);
    }

    @RequestMapping(value = "/listarTamano_json", method = RequestMethod.POST)
    @ResponseBody
    public Collection<Tamano> listarTamano(HttpSession session) throws Exception {
        Collection<Tamano> lista = null;
        try {
            lista = ArquitecturaApplication.getInstance().getTamanoService().listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
