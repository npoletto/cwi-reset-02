package br.com.cwi.reset.exemploreset.service;

import br.com.cwi.reset.exemploreset.dao.UsuarioDAO;
import br.com.cwi.reset.exemploreset.domain.Usuario;
import br.com.cwi.reset.exemploreset.exception.BadRequestException;
import br.com.cwi.reset.exemploreset.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;
    private int idUsuario=1;

    public List<Usuario> obterUsuarios() {
        return repository.getUsuarios();
    }

    public Usuario addUsuario(UsuarioDAO usuarioDAO) {
        if(usuarioDAO == null || usuarioDAO.getNome().isEmpty()) {
            throw new BadRequestException();
        }
        Usuario usuario = new Usuario(idUsuario++, usuarioDAO.getNome(), usuarioDAO.getEmail(), usuarioDAO.getSenha());
        repository.addUsuario(usuario);
        return usuario;
    }

    public void deletaUsuario(int id) {
        repository.deletaUsuario(id);
    }
}
