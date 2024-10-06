package com.demo.apirest.controller;


import com.demo.apirest.domain.Elemento;
import com.demo.apirest.service.ElementoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {
    private final ElementoService elementoService;

    // Esta es una inyección por constructor. Recuerda que la anotación @Autowired en este caso es opcional, ya que desde la versión 4.3 de Spring, cuando inyectamos por constructor (la forma recomendada por Spring) Spring entiende automáticamente la inyección.
    @Autowired
    public ApiController(ElementoService elementoService) {
        this.elementoService = elementoService;
    }

    @PostMapping(value = "/crear", produces = "application/json")
    public ResponseEntity<Elemento> crearElemento(@RequestBody Elemento elemento) {
        return ResponseEntity.ok(elementoService.crearElemento(elemento));
    }

    @GetMapping(value = "/elementos", produces = "application/json")
    public ResponseEntity<List<Elemento>> obtenerElementos() {
        return ResponseEntity.ok(elementoService.obtenerElementos());
    }

    @DeleteMapping("/elementos/{id}")
    public ResponseEntity<Void> eliminarElemento(@PathVariable Long id) {
        elementoService.eliminarElemento(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/elementos/{id}")
    public ResponseEntity<Elemento> updateElemento(@PathVariable Long id, @RequestBody Elemento elemento) {
        Elemento elementoActualizado = elementoService.updateElemento(id, elemento);
        if (elementoActualizado != null) {
            return ResponseEntity.ok(elementoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}