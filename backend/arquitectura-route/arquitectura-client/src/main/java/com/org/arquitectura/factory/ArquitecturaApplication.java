package com.org.arquitectura.factory;

import com.org.arquitectura.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ArquitecturaApplication {

    private static final ArquitecturaApplication ARQ_FACTORY = new ArquitecturaApplication();
    private ApplicationContext context = null;

    public ArquitecturaApplication() {
        try {
            context = new ClassPathXmlApplicationContext(new String[]{
                    "com/org/arquitectura/spring/config/arquitectura-aplication-context.xml",
                    "com/org/arquitectura/spring/config/repositorioBean.xml",
                    "com/org/arquitectura/spring/config/serviceBean.xml",
                    "com/org/arquitectura/spring/config/transactionBean.xml"});
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    public static ArquitecturaApplication getInstance() {
        return ARQ_FACTORY;
    }

    public TipoService getTipoService() {
        return context.getBean("tipo-service", TipoService.class);
    }

    public RazaService getRazaService() {
        return context.getBean("raza-service", RazaService.class);
    }

    public ColorService getColorService() {
        return context.getBean("color-service", ColorService.class);
    }

    public EstadoService getEstadoService() {
        return context.getBean("estado-service", EstadoService.class);
    }

    public SituacionService getSituacionService() {
        return context.getBean("situacion-service", SituacionService.class);
    }

    public TamanoService getTamanoService() {
        return context.getBean("tamano-service", TamanoService.class);
    }

    public AnimalService getAnimalService() {
        return context.getBean("animal-service", AnimalService.class);
    }

    public GeneroService getGeneroService() {
        return context.getBean("genero-service", GeneroService.class);
    }

    public HorarioService getHorarioService() {
        return context.getBean("horario-service", HorarioService.class);
    }

    public PersonaService getPersonaService() {
        return context.getBean("persona-service", PersonaService.class);
    }

    public RolService getRolService() {
        return context.getBean("rol-service", RolService.class);
    }

    public UsuarioService getUsuarioService() {
        return context.getBean("usuario-service", UsuarioService.class);
    }

    public DireccionService getDireccionService() {
        return context.getBean("direccion-service", DireccionService.class);
    }

    public EmpleadoService getEmpleadoService() {
        return context.getBean("empleado-service", EmpleadoService.class);
    }

    public EmpleadoHorarioService getEmpleadoHorarioService() {
        return context.getBean("empleadoHorario-service", EmpleadoHorarioService.class);
    }

    public CitaService getCitaService() {
        return context.getBean("cita-service", CitaService.class);
    }

}
