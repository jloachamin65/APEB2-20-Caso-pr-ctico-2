package com.org.arquitectura.web.refugio;

import com.org.arquitectura.entities.Empleado;
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
public class EmpleadoController {
    @RequestMapping(value = "/listarEmpleadoPaginado_json", method = RequestMethod.POST)
    @ResponseBody
    public PagedResult listarEmpleadoPaginado(@RequestBody FilterParam filterParam, HttpSession session) throws Exception {
        PagedResult pagedResult = null;
        try {
            pagedResult = ArquitecturaApplication.getInstance().getEmpleadoService().listarPaginado(filterParam);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pagedResult;
    }

    @RequestMapping(value = "/registrarEmpleado_json", method = RequestMethod.POST)
    @ResponseBody
    public void registrarEmpleado(@RequestBody Empleado empleado, HttpSession session) throws Exception {

        ArquitecturaApplication.getInstance().getEmpleadoService().crearRegistro(empleado);
    }

    @RequestMapping(value = "/eliminarEmpleado_json", method = RequestMethod.POST)
    @ResponseBody
    public void eliminarEmpleado(@RequestBody Empleado empleado, HttpSession session) throws Exception {

        ArquitecturaApplication.getInstance().getEmpleadoService().eliminarRegistro(empleado);
    }

    @RequestMapping(value = "/listarEmpleado_json", method = RequestMethod.POST)
    @ResponseBody
    public Collection<Empleado> listarEmpleado(HttpSession session) throws Exception {
        Collection<Empleado> lista = null;
        try {
            lista = ArquitecturaApplication.getInstance().getEmpleadoService().listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
