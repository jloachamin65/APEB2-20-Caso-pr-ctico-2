package com.org.arquitectura.entities;

import javax.persistence.*;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "persona", schema = "refugio")
public class Persona implements Serializable {

    private static final long serialVersionUID = ObjectStreamClass.lookup(Persona.class).getSerialVersionUID();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona", unique = true, nullable = false)
    private Integer idPersona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_genero", nullable = false)
    private Genero genero;

    @Column(name = "nombre", unique = true, nullable = false)
    private String nombre;

    @Column(name = "apellido_paterno", unique = true, nullable = false)
    private String apellidoPaterno;

    @Column(name = "apellido_materno", unique = true, nullable = false)
    private String apellidoMaterno;

    @Column(name = "identificacion", unique = true, nullable = false)
    private String identificacion;

    @Column(name = "fecha_nacimiento", unique = true, nullable = false)
    private Date fechaNacimiento;

    @Column(name = "descripcion", unique = true, nullable = false)
    private String descripcion;

    @Column(name = "correo", unique = true, nullable = false)
    private String correo;

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
