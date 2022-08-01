package com.org.arquitectura.entities;

import javax.persistence.*;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "horario", schema = "refugio")
public class Horario implements Serializable {

    private static final long serialVersionUID = ObjectStreamClass.lookup(Horario.class).getSerialVersionUID();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario", unique = true, nullable = false)
    private Integer idHorario;

    @Column(name = "codigo", unique = true, nullable = false)
    private String codigo;

    @Column(name = "fecha", unique = true, nullable = false)
    private Date fecha;

    @Column(name = "hora", unique = true, nullable = false)
    private Integer hora;

    @Column(name = "estado", unique = true, nullable = false)
    private Character estado;

    @Column(name = "descripcion", unique = true, nullable = false)
    private String descripcion;

    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
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

    public Integer getHora() {
        return hora;
    }

    public void setHora(Integer hora) {
        this.hora = hora;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
