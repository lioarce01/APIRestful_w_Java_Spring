package com.demo.apirest.service;

import com.demo.apirest.domain.Elemento;

import java.util.List;

public interface ElementoService {
    Elemento crearElemento(Elemento elemento);
    List<Elemento> obtenerElementos();
    void eliminarElemento(Long id);
    Elemento updateElemento(Long id, Elemento elemento);
}