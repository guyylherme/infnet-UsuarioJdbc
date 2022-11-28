package br.edu.infnet.usuario.domain.model;

import org.junit.Test;

import br.edu.infnet.usuario.model.Usuario;

public class UsuarioTeste {

    @Test
    public void testToString() {
        System.out.println(new Usuario("Luciene", "Medeiros", 48, "05/11/1980"));
    }
}