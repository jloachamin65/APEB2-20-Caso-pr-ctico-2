package com.org.arquitectura.web.refugio;

import com.org.arquitectura.entities.Horario;
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
public class HorarioController {

    @RequestMapping(value = "/listarHorarioPaginado_json", method = RequestMethod.POST)
    @ResponseBody
    public PagedResult<Horario> listarHorarioPaginado(@RequestBody FilterParam filterParam, HttpSession session) throws Exception {
        PagedResult<Horario> pagedResult = null;
        try {
            pagedResult = ArquitecturaApplication.getInstance().getHorarioService().listarPaginado(filterParam);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pagedResult;
    }

    @RequestMapping(value = "/registrarHorario_json", method = RequestMethod.POST)
    @ResponseBody
    public void registrarHorario(@RequestBody Horario horario, HttpSession session) throws Exception {

        ArquitecturaApplication.getInstance().getHorarioService().crearRegistro(horario);
    }

    @RequestMapping(value = "/eliminarHorario_json", method = RequestMethod.POST)
    @ResponseBody
    public void eliminarHorario(@RequestBody Horario horario, HttpSession session) throws Exception {

        ArquitecturaApplication.getInstance().getHorarioService().eliminarRegistro(horario);
    }

    @RequestMapping(value = "/listarHorario_json", method = RequestMethod.POST)
    @ResponseBody
    public Collection<Horario> listarHorario(HttpSession session) throws Exception {
        Collection<Horario> lista = null;
        try {
            lista = ArquitecturaApplication.getInstance().getHorarioService().listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
