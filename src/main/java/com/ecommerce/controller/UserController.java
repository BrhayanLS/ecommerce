package com.ecommerce.controller;
import com.ecommerce.DTO.userDTO;
import com.ecommerce.Repository.userRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private userRepository usuarioRepository;

    // Endpoint para obtener todos los usuarios
    @GetMapping
    public List<userDTO> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }

    // Endpoint para obtener un usuario por su ID
    @GetMapping("/{id}")
    public userDTO obtenerUsuarioPorId(@PathVariable String id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    // Endpoint para crear un nuevo usuario
    @PostMapping
    public ResponseEntity<userDTO> crearUsuario(@RequestBody userDTO usuario) {
        // Realizar validaciones u operaciones adicionales si es necesario
        try {
            userDTO nuevoUsuario = usuarioRepository.save(usuario);
            return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
        } catch (Exception e) {
            // Manejar cualquier excepción que pueda ocurrir al guardar el usuario
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint para actualizar un usuario existente
    @PutMapping("/{id}")
    public userDTO actualizarUsuario(@PathVariable String id, @RequestBody userDTO usuario) {
        if (usuarioRepository.existsById(id)) {
            usuario.setId(id);
            return usuarioRepository.save(usuario);
        } else {
            return null; // Manejar el caso en que el usuario no exista
        }
    }

    // Endpoint para eliminar un usuario por su ID
    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable String id) {
        usuarioRepository.deleteById(id);
    }
}
