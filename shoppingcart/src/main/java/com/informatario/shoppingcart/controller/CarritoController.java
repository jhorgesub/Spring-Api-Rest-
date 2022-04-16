package com.informatario.shoppingcart.controller;

import com.informatario.shoppingcart.entity.Carrito;
import com.informatario.shoppingcart.entity.Usuario;
import com.informatario.shoppingcart.repository.CarritoRepository;
import com.informatario.shoppingcart.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;

@RestController
public class CarritoController {

    private UsuarioRepository usuarioRepository;
    private CarritoRepository carritoRepository;

    @RequestMapping("usuario/{idUser}/carrito")
    public ResponseEntity<?> crearCarrito(@PathVariable("idUser") Long idUser,
                                          @RequestBody Carrito carrito) {
        Usuario usuario = usuarioRepository.findById(idUser)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encntrado"));
        carrito.setUsuario(usuario);
        return new ResponseEntity(carritoRepository.save(carrito), HttpStatus.CREATED);
    }

    public CarritoController(UsuarioRepository usuarioRepository, CarritoRepository carritoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.carritoRepository = carritoRepository;
    }
}
