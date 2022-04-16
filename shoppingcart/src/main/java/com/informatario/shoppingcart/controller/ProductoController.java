package com.informatario.shoppingcart.controller;

import com.informatario.shoppingcart.entity.Producto;
import com.informatario.shoppingcart.repository.ProductoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/producto")
public class ProductoController {

    private ProductoRepository productoRepository;

    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity(productoRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Producto producto) {
        return new ResponseEntity(productoRepository.save(producto), HttpStatus.CREATED);
    }

}
