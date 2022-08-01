package com.org.arquitectura.web.refugio;

import com.org.arquitectura.entities.Raza;
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
public class RazaController {

    @RequestMapping(value = "/listarRazaPaginado_json", method = RequestMethod.POST)
    @ResponseBody
    public PagedResult listarRazaPaginado(@RequestBody FilterParam filterParam, HttpSession session) throws Exception {
        PagedResult pagedResult = null;
        try {
            pagedResult = ArquitecturaApplication.getInstance().getRazaService().listarRazaPaginado(filterParam);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pagedResult;
    }

    @RequestMapping(value = "/registrarRaza_json", method = RequestMethod.POST)
    @ResponseBody
    public void registrarRaza(@RequestBody Raza raza, HttpSession session) throws Exception {

        ArquitecturaApplication.getInstance().getRazaService().crearRegistro(raza);
    }

    @RequestMapping(value = "/eliminarRaza_json", method = RequestMethod.POST)
    @ResponseBody
    public void eliminarRaza(@RequestBody Raza raza, HttpSession session) throws Exception {

        ArquitecturaApplication.getInstance().getRazaService().eliminarRegistro(raza);
    }

    @RequestMapping(value = "/listarRaza_json", method = RequestMethod.POST)
    @ResponseBody
    public Collection<Raza> listarAnimal(HttpSession session) throws Exception {
        Collection<Raza> lista = null;
        try {
            lista = ArquitecturaApplication.getInstance().getRazaService().listarRaza();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
