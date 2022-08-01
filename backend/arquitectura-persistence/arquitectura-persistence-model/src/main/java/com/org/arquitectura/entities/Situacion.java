package com.org.arquitectura.entities;

import javax.persistence.*;
import java.io.ObjectStreamClass;
import java.io.Serializable;

@Entity
@Table(name = "situacion", schema = "refugio")
public class Situacion implements Serializable {
    private static final long serialVersionUID = ObjectStreamClass.lookup(Situacion.class).getSerialVersionUID();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_situacion", unique = true, nullable = false)
    private Integer idSituacion;

    @Column(name = "codigo", unique = true, nullable = false)
    private String codigo;

    @Column(name = "situacion", unique = true, nullable = false)
    private String situacion;

    @Column(name = "descripcion", unique = true, nullable = false)
    private String descripcion;

    public Integer getIdSituacion() {
        return idSituacion;
    }

    public void setIdSituacion(Integer idSituacion) {
        this.idSituacion = idSituacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
