package org.pbe.demo.services;

import org.pbe.demo.entidades.Usuario;
import org.pbe.demo.entidades.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario criaUsuario(String nome, String sobrenome) {
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setSobrenome(sobrenome);

        return usuarioRepository.save(usuario);
    }
}

