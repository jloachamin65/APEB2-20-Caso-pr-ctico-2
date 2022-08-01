package com.org.arquitectura.entities;

import javax.persistence.*;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "cita", schema = "refugio")
public class Cita implements Serializable {

    private static final long serialVersionUID = ObjectStreamClass.lookup(Cita.class).getSerialVersionUID();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita", unique = true, nullable = false)
    private Integer idCita;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empleado_horario", nullable = false)
    private EmpleadoHorario empleadoHorario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_animal", nullable = false)
    private Animal animal;

    @Column(name = "codigo", unique = true, nullable = false)
    private String codigo;

    @Column(name = "fecha", unique = true, nullable = false)
    private Date fecha;

    @Column(name = "descripcion", unique = true, nullable = false)
    private String descripcion;

    @Column(name = "estado", unique = true, nullable = false, length = 1)
    private Character estado;

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public EmpleadoHorario getEmpleadoHorario() {
        return empleadoHorario;
    }

    public void setEmpleadoHorario(EmpleadoHorario empleadoHorario) {
        this.empleadoHorario = empleadoHorario;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }
}
