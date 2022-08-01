package com.org.arquitectura.web.refugio;

import com.org.arquitectura.entities.Rol;
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
public class RolController {
    @RequestMapping(value = "/listarRolPaginado_json", method = RequestMethod.POST)
    @ResponseBody
    public PagedResult listarRolPaginado(@RequestBody FilterParam filterParam, HttpSession session) throws Exception {
        PagedResult pagedResult = null;
        try {
            pagedResult = ArquitecturaApplication.getInstance().getRolService().listarPaginado(filterParam);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pagedResult;
    }

    @RequestMapping(value = "/registrarRol_json", method = RequestMethod.POST)
    @ResponseBody
    public void registrarRol(@RequestBody Rol rol, HttpSession session) throws Exception {

        ArquitecturaApplication.getInstance().getRolService().crearRegistro(rol);
    }

    @RequestMapping(value = "/eliminarRol_json", method = RequestMethod.POST)
    @ResponseBody
    public void eliminarRol(@RequestBody Rol rol, HttpSession session) throws Exception {

        ArquitecturaApplication.getInstance().getRolService().eliminarRegistro(rol);
    }

    @RequestMapping(value = "/listarRol_json", method = RequestMethod.POST)
    @ResponseBody
    public Collection<Rol> listarRol(HttpSession session) throws Exception {
        Collection<Rol> lista = null;
        try {
            lista = ArquitecturaApplication.getInstance().getRolService().listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
