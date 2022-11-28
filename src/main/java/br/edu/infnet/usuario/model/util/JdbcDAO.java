package br.edu.infnet.usuario.model.util;

import java.sql.Connection;

public abstract class JdbcDAO {

    protected Connection connection;

    public JdbcDAO() {
        connection = JdbcUtil.getConnection();
    }
}
