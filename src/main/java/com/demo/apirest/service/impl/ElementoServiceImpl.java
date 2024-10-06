package com.demo.apirest.service.impl;

import com.demo.apirest.domain.Elemento;
import com.demo.apirest.service.ElementoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ElementoServiceImpl implements ElementoService {
    private List<Elemento> elementos = new ArrayList<>();

    @Override
    public Elemento crearElemento(Elemento elemento) {
        if (elemento.getId() == null) {
            elemento.setId((long) (elementos.size() + 1));
        }
        elementos.add(elemento);
        return elemento;
    }

    @Override
    public List<Elemento> obtenerElementos() {
        return elementos;
    }

    @Override
    public void eliminarElemento(Long id) {
        elementos.removeIf(elemento -> elemento.getId().equals(id));
    }

    @Override
    public Elemento updateElemento(Long id, Elemento elementoActualizado) {
        for(Elemento elemento : elementos) {
            if (elemento.getId().equals(id)) {
                elemento.setNombre(elementoActualizado.getNombre());
                return elemento;
            }
        }
        return null;
    }
}