package com.demo.apirest.domain;

public class Elemento {
    private Long id;
    private String nombre;

    // Constructor vacío (necesario para Jackson)
    public Elemento() {}

    // Constructor con parámetros
    public Elemento(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter y Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}