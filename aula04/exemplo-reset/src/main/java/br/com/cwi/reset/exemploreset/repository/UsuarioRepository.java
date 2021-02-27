package br.com.cwi.reset.exemploreset.repository;

import br.com.cwi.reset.exemploreset.domain.Usuario;
import br.com.cwi.reset.exemploreset.exception.BadRequestException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class UsuarioRepository {

    static HashMap<Integer, Usuario> usuarios = new HashMap();

    public ArrayList<Usuario> getUsuarios() {
        ArrayList<Usuario> lista = new ArrayList<>(usuarios.values());
        return lista;
    }

    public Usuario addUsuario(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
        return usuario;
    }

    public void deletaUsuario(int id) {
        if(usuarios.remove(id)==null) throw new BadRequestException();
    }

}
