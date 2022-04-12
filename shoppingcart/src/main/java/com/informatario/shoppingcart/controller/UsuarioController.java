package com.informatario.shoppingcart.controller;

import com.informatario.shoppingcart.entity.Usuario;
import com.informatario.shoppingcart.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/usuario") //si se coloca a nivel de clase, no es necesario colocar a cada ruta de los métodos
public class UsuarioController {

    private UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity(usuarioRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody Usuario usuario) {
        return new ResponseEntity(usuarioRepository.save(usuario), HttpStatus.CREATED);

    }


}

