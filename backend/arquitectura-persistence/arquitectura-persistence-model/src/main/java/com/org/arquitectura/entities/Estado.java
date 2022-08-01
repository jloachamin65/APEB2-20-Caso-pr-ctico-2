package com.org.arquitectura.entities;

import javax.persistence.*;
import java.io.ObjectStreamClass;
import java.io.Serializable;

@Entity
@Table(name = "estado", schema = "refugio")
public class Estado implements Serializable {
    private static final long serialVersionUID = ObjectStreamClass.lookup(Estado.class).getSerialVersionUID();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado", unique = true, nullable = false)
    private Integer idEstado;

    @Column(name = "codigo", unique = true, nullable = false)
    private String codigo;

    @Column(name = "estado", unique = true, nullable = false)
    private String estado;

    @Column(name = "descripcion", unique = true, nullable = false)
    private String descripcion;

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
