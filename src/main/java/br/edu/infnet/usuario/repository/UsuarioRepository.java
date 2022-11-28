package br.edu.infnet.usuario.repository;

import java.util.List;
import java.util.Optional;

import br.edu.infnet.usuario.model.Usuario;

public interface UsuarioRepository {

    void create(Usuario user);

    Optional<Usuario> findById(Integer id);

    List<Usuario> findAll();

    Usuario updateById(Integer id, Usuario user);

    void deleteById(Integer id);
}
