package br.com.cwi.reset.exemploreset.controller;


import br.com.cwi.reset.exemploreset.dao.UsuarioDAO;
import br.com.cwi.reset.exemploreset.domain.Usuario;
import br.com.cwi.reset.exemploreset.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getUsuarios(){
        return usuarioService.obterUsuarios();
    }

    @PostMapping
    public Usuario criarUsuario(@RequestBody UsuarioDAO usuarioDAO){
        return usuarioService.addUsuario(usuarioDAO);
    }

    @DeleteMapping("/{id}")
    public void deletaUsuario(@PathVariable("id") Integer id) {
        usuarioService.deletaUsuario(id);
    }
}
