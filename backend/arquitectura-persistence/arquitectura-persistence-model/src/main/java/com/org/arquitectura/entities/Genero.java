package com.org.arquitectura.entities;

import javax.persistence.*;
import java.io.ObjectStreamClass;
import java.io.Serializable;

@Entity
@Table(name = "genero", schema = "refugio")
public class Genero implements Serializable {

    private static final long serialVersionUID = ObjectStreamClass.lookup(Genero.class).getSerialVersionUID();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_genero", unique = true, nullable = false)
    private Integer idGenero;

    @Column(name = "codigo", unique = true, nullable = false)
    private Character codigo;

    @Column(name = "nombre", unique = true, nullable = false)
    private String nombre;

    public Integer getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    public Character getCodigo() {
        return codigo;
    }

    public void setCodigo(Character codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
