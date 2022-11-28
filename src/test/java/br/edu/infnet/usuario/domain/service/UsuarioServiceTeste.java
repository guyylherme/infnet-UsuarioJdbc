package br.edu.infnet.usuario.domain.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.edu.infnet.usuario.model.Usuario;
import br.edu.infnet.usuario.model.service.UsuarioService;
 

public class UsuarioServiceTeste {

    private UsuarioService service;

    public UsuarioServiceTeste() {
        this.service = new UsuarioService();
    }

    @Test
    public void criarUsuario() {
        service.create(new Usuario("Felipe", "Santos", 21, "05/10/2001"));
        Assert.assertTrue("Successo ao inserir o usuario", true);
    }

    @Test
    public void buscarUsuarioPorId() {
        Usuario usuario = service.findById(1);
        Assert.assertNotNull(usuario);
        Assert.assertTrue("Successo ao buscar o usuario por id", true);
    }
 
    @Test
    public void buscarUsuarios() {
        List<Usuario> usuario = service.findAll();
        Assert.assertNotNull(usuario);
        Assert.assertTrue("Successo ao buscar todos os usuários", true);
    }

    @Test
    public void atualizarUsuario() {
        Usuario usuario = service.updateById(1, new Usuario("Marcos", "Medeiros", 33, "05/11/1988"));
        Assert.assertNotNull(usuario);
        Assert.assertTrue("Successo ao alterar usuário", true);
    }
    
    @Test
    public void removerUsuario() {
    	service.deleteById(1); 
    }

}