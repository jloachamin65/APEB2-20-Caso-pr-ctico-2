package com.org.arquitectura.entities;

import javax.persistence.*;
import java.io.ObjectStreamClass;
import java.io.Serializable;

@Entity
@Table(name = "empleado_horario", schema = "refugio")
public class EmpleadoHorario implements Serializable {

    private static final long serialVersionUID = ObjectStreamClass.lookup(EmpleadoHorario.class).getSerialVersionUID();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado_horario", unique = true, nullable = false)
    private Integer idEmpleadoHorario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleado empleado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_horario", nullable = false)
    private Horario horario;

    @Column(name = "descripcion", unique = true, nullable = false)
    private String descripcion;

    @Column(name = "estado", unique = true, nullable = false)
    private Character estado;

    public Integer getIdEmpleadoHorario() {
        return idEmpleadoHorario;
    }

    public void setIdEmpleadoHorario(Integer idEmpleadoHorario) {
        this.idEmpleadoHorario = idEmpleadoHorario;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
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
