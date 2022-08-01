package com.org.arquitectura;

import com.org.arquitectura.common.RefugioPersistException;
import com.org.arquitectura.common.RefugioSearchException;
import com.org.arquitectura.entities.*;
import com.org.arquitectura.factory.ArquitecturaFactory;
import com.org.arquitectura.util.FilterParam;
import com.org.arquitectura.util.PagedResult;
import org.junit.Test;

public class AnimalTest {

    @Test
    public void listarPaginado() {
        PagedResult<Animal> lista = null;
        FilterParam filterParam = new FilterParam();
        filterParam.setFirstResult(0);
        filterParam.setItemPerPage(3);
        try {
            lista = ArquitecturaFactory.getInstance().getAnimalService().listarPaginado(filterParam);
            for (Animal r : lista.getItems()) {
                System.out.println(r.getCodigo() + " " +
                        r.getNombre() + " " +
                        r.getDescripcion() + " " +
                        r.getRaza().getNombre() + " " +
                        r.getColor().getNombre() + " " +
                        r.getTamano().getNombre() + " " +
                        r.getSituacion().getSituacion() + " " +
                        r.getEstado().getEstado());
            }
        } catch (RefugioSearchException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void crear() {
        Animal animal = new Animal();
        animal.setCodigo("1");
        animal.setNombre("LUCAS");
        animal.setDescripcion("LUCAS");

        Raza raza = new Raza();
        raza.setIdRaza(1);

        Tipo tipo = new Tipo();
        tipo.setIdTipo(1);
        raza.setTipo(tipo);

        Color color = new Color();
        color.setIdColor(1);

        Tamano tamano = new Tamano();
        tamano.setIdTamano(2);

        Situacion situacion = new Situacion();
        situacion.setIdSituacion(3);

        Estado estado = new Estado();
        estado.setIdEstado(4);

        animal.setRaza(raza);
        animal.setColor(color);
        animal.setTamano(tamano);
        animal.setSituacion(situacion);
        animal.setEstado(estado);

        try {
            ArquitecturaFactory.getInstance().getAnimalService().crearRegistro(animal);

        } catch (RefugioPersistException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void actualizar() {
        Animal animal = new Animal();
        animal.setIdAnimal(1);
        animal.setCodigo("1");
        animal.setNombre("LUCAS");
        animal.setDescripcion("LUCAS PRUEBA");

        Raza raza = new Raza();
        raza.setIdRaza(1);

        Tipo tipo = new Tipo();
        tipo.setIdTipo(1);
        raza.setTipo(tipo);

        Color color = new Color();
        color.setIdColor(1);

        Tamano tamano = new Tamano();
        tamano.setIdTamano(2);

        Situacion situacion = new Situacion();
        situacion.setIdSituacion(3);

        Estado estado = new Estado();
        estado.setIdEstado(4);

        animal.setRaza(raza);
        animal.setColor(color);
        animal.setTamano(tamano);
        animal.setSituacion(situacion);
        animal.setEstado(estado);

        try {
            ArquitecturaFactory.getInstance().getAnimalService().actualizarRegistro(animal);

        } catch (RefugioPersistException e) {
            e.printStackTrace();
        }
    }
}
