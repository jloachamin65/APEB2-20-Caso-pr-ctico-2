package com.org.arquitectura.web.refugio;

import com.org.arquitectura.entities.EmpleadoHorario;
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
public class EmpleadoHorarioController {

    @RequestMapping(value = "/listarEmpleadoHorarioPaginado_json", method = RequestMethod.POST)
    @ResponseBody
    public PagedResult listarEmpleadoHorarioPaginado(@RequestBody FilterParam filterParam, HttpSession session) throws Exception {
        PagedResult pagedResult = null;
        try {
            pagedResult = ArquitecturaApplication.getInstance().getEmpleadoHorarioService().listarPaginado(filterParam);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pagedResult;
    }

    @RequestMapping(value = "/registrarEmpleadoHorario_json", method = RequestMethod.POST)
    @ResponseBody
    public void registrarEmpleadoHorario(@RequestBody EmpleadoHorario empleadoHorario, HttpSession session) throws Exception {

        ArquitecturaApplication.getInstance().getEmpleadoHorarioService().crearRegistro(empleadoHorario);
    }

    @RequestMapping(value = "/eliminarEmpleadoHorario_json", method = RequestMethod.POST)
    @ResponseBody
    public void eliminarEmpleadoHorario(@RequestBody EmpleadoHorario empleadoHorario, HttpSession session) throws Exception {

        ArquitecturaApplication.getInstance().getEmpleadoHorarioService().eliminarRegistro(empleadoHorario);
    }

    @RequestMapping(value = "/listarEmpleadoHorario_json", method = RequestMethod.POST)
    @ResponseBody
    public Collection<EmpleadoHorario> listarEmpleadoHorario(HttpSession session) throws Exception {
        Collection<EmpleadoHorario> lista = null;
        try {
            lista = ArquitecturaApplication.getInstance().getEmpleadoHorarioService().listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
