package br.edu.infnet.usuario.infrastructure.util;

import org.junit.Assert;
import org.junit.Test;

import br.edu.infnet.usuario.model.util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcUtilTest {

    @Test
    public void getConnection() {
        try (Connection connection = JdbcUtil.getConnection();) {
            Assert.assertTrue("Successo ao conectar", true);
            System.out.println("Successo ao conectar");
        } catch (SQLException sqlException) {
            Assert.fail();
        }
    }
}