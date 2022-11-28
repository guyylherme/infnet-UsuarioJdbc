package br.edu.infnet.usuario.model.service;

import br.edu.infnet.usuario.model.Usuario;
import br.edu.infnet.usuario.repository.UsuarioRepository;
import br.edu.infnet.usuario.repository.bean.UsuarioRepositoryImpl;

import java.util.List;

public class UsuarioService {

    private UsuarioRepository UsuarioRepository;

    public UsuarioService() {
        this.UsuarioRepository = new UsuarioRepositoryImpl();
    }

    public void create(Usuario usuario) {
        UsuarioRepository.create(usuario);	
    }

    public Usuario findById(Integer id) {
        return UsuarioRepository.findById(id).get();
    }

    public List<Usuario> findAll() {
        return UsuarioRepository.findAll();
    }

    public Usuario updateById(Integer id, Usuario usuario) {
        return UsuarioRepository.updateById(id, usuario);
    }

    public void deleteById(Integer id) {
        UsuarioRepository.deleteById(id);
    }
}
