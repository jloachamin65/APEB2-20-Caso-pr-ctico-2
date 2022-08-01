package com.org.arquitectura.entities;

import javax.persistence.*;
import java.io.ObjectStreamClass;
import java.io.Serializable;

@Entity
@Table(name = "tamano", schema = "refugio")
public class Tamano implements Serializable {
    private static final long serialVersionUID = ObjectStreamClass.lookup(Tamano.class).getSerialVersionUID();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tamano", unique = true, nullable = false)
    private Integer idTamano;

    @Column(name = "codigo", unique = true, nullable = false)
    private String codigo;

    @Column(name = "nombre", unique = true, nullable = false)
    private String nombre;

    public Integer getIdTamano() {
        return idTamano;
    }

    public void setIdTamano(Integer idTamano) {
        this.idTamano = idTamano;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
