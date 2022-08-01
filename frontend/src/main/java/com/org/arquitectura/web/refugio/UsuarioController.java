package com.org.arquitectura.web.refugio;

import com.org.arquitectura.entities.Usuario;
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
public class UsuarioController {

    @RequestMapping(value = "/listarUsuarioPaginado_json", method = RequestMethod.POST)
    @ResponseBody
    public PagedResult listarUsuarioPaginado(@RequestBody FilterParam filterParam, HttpSession session) throws Exception {
        PagedResult pagedResult = null;
        try {
            pagedResult = ArquitecturaApplication.getInstance().getUsuarioService().listarPaginado(filterParam);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pagedResult;
    }

    @RequestMapping(value = "/registrarUsuario_json", method = RequestMethod.POST)
    @ResponseBody
    public void registrarUsuario(@RequestBody Usuario usuario, HttpSession session) throws Exception {

        ArquitecturaApplication.getInstance().getUsuarioService().crearRegistro(usuario);
    }

    @RequestMapping(value = "/eliminarUsuario_json", method = RequestMethod.POST)
    @ResponseBody
    public void eliminarUsuario(@RequestBody Usuario usuario, HttpSession session) throws Exception {

        ArquitecturaApplication.getInstance().getUsuarioService().eliminarRegistro(usuario);
    }

    @RequestMapping(value = "/listarUsuario_json", method = RequestMethod.POST)
    @ResponseBody
    public Collection<Usuario> listarColor(HttpSession session) throws Exception {
        Collection<Usuario> lista = null;
        try {
            lista = ArquitecturaApplication.getInstance().getUsuarioService().listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
