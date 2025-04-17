package org.pbe.demo.controllers;

import org.pbe.demo.entidades.Usuario;
import org.pbe.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/usuario/cria")
    public Usuario criarUsuario(@RequestParam String nome, @RequestParam String sobrenome) {
        return usuarioService.criaUsuario(nome, sobrenome);
    }

}
