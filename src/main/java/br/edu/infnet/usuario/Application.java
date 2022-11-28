package br.edu.infnet.usuario;

import br.edu.infnet.usuario.model.util.JdbcUtil;

public class Application {
    public static void main(String[] args) {
    	JdbcUtil.getConnection();
        System.out.println("Aplicação inicializada com sucesso!");
        System.out.println();
    }
}