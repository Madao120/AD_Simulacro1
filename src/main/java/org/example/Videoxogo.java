package org.example;

import java.io.Serializable;

public class Videoxogo implements Serializable {
    private String id;
    private String titulo;
    private String plataforma;
    private String anolanzamento;
    private String descripcion;


    public Videoxogo(String titulo, String plataforma, String anolanzamento, String descripcion) {
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.anolanzamento = anolanzamento;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public String getAnolanzamento() {
        return anolanzamento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public void setAnolanzamento(String anolanzamento) {
        this.anolanzamento = anolanzamento;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
