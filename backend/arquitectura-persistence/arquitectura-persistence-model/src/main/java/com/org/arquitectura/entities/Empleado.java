package com.org.arquitectura.entities;

import javax.persistence.*;
import java.io.ObjectStreamClass;
import java.io.Serializable;

@Entity
@Table(name = "empleado", schema = "refugio")
public class Empleado implements Serializable {

    private static final long serialVersionUID = ObjectStreamClass.lookup(Empleado.class).getSerialVersionUID();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado", unique = true, nullable = false)
    private Integer idEmpleado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;

    @Column(name = "codigo", unique = true, nullable = false)
    private String codigo;

    @Column(name = "cargo", unique = true, nullable = false)
    private String cargo;

    @Column(name = "descripcion", unique = true, nullable = false)
    private String descripcion;

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
