package com.org.arquitectura.web.refugio;

import com.org.arquitectura.entities.Animal;
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
public class AnimalController {

    @RequestMapping(value = "/listarAnimalPaginado_json", method = RequestMethod.POST)
    @ResponseBody
    public PagedResult listarAnimalPaginado(@RequestBody FilterParam filterParam, HttpSession session) throws Exception {
        PagedResult pagedResult = null;
        try {
            pagedResult = ArquitecturaApplication.getInstance().getAnimalService().listarPaginado(filterParam);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pagedResult;
    }

    @RequestMapping(value = "/registrarAnimal_json", method = RequestMethod.POST)
    @ResponseBody
    public void registrarTipo(@RequestBody Animal animal, HttpSession session) throws Exception {

        ArquitecturaApplication.getInstance().getAnimalService().crearRegistro(animal);
    }

    @RequestMapping(value = "/eliminarAnimal_json", method = RequestMethod.POST)
    @ResponseBody
    public void eliminarTipo(@RequestBody Animal animal, HttpSession session) throws Exception {

        ArquitecturaApplication.getInstance().getAnimalService().eliminarRegistro(animal);
    }

    @RequestMapping(value = "/listarAnimal_json", method = RequestMethod.POST)
    @ResponseBody
    public Collection<Animal> listarAnimal(HttpSession session) throws Exception {
        Collection<Animal> lista = null;
        try {
            lista = ArquitecturaApplication.getInstance().getAnimalService().listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    @RequestMapping(value = "/actualizarAnimal_json", method = RequestMethod.POST)
    @ResponseBody
    public void actualizarTipo(@RequestBody Animal animal, HttpSession session) throws Exception {

        ArquitecturaApplication.getInstance().getAnimalService().actualizarRegistro(animal);
    }
}
