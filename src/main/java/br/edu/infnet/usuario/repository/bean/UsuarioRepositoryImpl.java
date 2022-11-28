package br.edu.infnet.usuario.repository.bean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.edu.infnet.usuario.model.Usuario;
import br.edu.infnet.usuario.model.util.JdbcDAO;
import br.edu.infnet.usuario.repository.UsuarioRepository;

public class UsuarioRepositoryImpl extends JdbcDAO implements UsuarioRepository {
	
	 private PreparedStatement getPrepareStatement(String sql) throws SQLException {
	        return connection.prepareStatement(sql);
	    }

    @Override
    public void create(Usuario usuario) {
        try {
            String sql = "insert into usuario(nome, sobrenome, idade, nascimento) values (?,?,?,?)";
            PreparedStatement preparedStatement = getPrepareStatement(sql);
            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getSobrenome());
            preparedStatement.setInt(3, usuario.getIdade());
            preparedStatement.setString(4, usuario.getNascimento());
            preparedStatement.executeUpdate();
            
        } catch (SQLException sqlException) {
            sqlException.getStackTrace();
            throw new RuntimeException(String.format("Erro ao inserir usuario, mensagem: %s", sqlException.getMessage()));
        }
    }

    @Override
    public Optional<Usuario> findById(Integer id) {
        try {
            String sql = "select * from usuario where id = ?";
            PreparedStatement preparedStatement = getPrepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            Optional<Usuario> Usuario = Optional.empty();
            while (resultSet.next()) {
            	 String nome = resultSet.getString("nome");
                 String sobrenome = resultSet.getString("sobrenome");
                 Integer idade = resultSet.getInt("idade");
                 String nascimento = resultSet.getString("nascimento");
                 Usuario = Optional.of(new Usuario(nome, sobrenome, idade, nascimento));
            }
            
            return Usuario;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Usuario> findAll() {
        try {
            String sql = "select * from usuario";
            PreparedStatement preparedStatement = getPrepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Usuario> Usuario = new ArrayList<>();
            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String sobrenome = resultSet.getString("sobrenome");
                Integer idade = resultSet.getInt("idade");
                String nascimento = resultSet.getString("nascimento");
                Usuario.add(new Usuario(nome, sobrenome, idade, nascimento));
            }
            return Usuario;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Usuario updateById(Integer id, Usuario usuario) {
        try {        	
            String sql = "update usuario set nome = ?, sobrenome = ?, idade = ?, nascimento = ? where id = ?";
            PreparedStatement prepareStatement = getPrepareStatement(sql);
            prepareStatement.setString(1, usuario.getNome());
            prepareStatement.setString(2, usuario.getSobrenome());
            prepareStatement.setInt(3, usuario.getIdade());
            prepareStatement.setString(4, usuario.getNascimento());
            prepareStatement.setInt(5, id);
            prepareStatement.executeUpdate();
            

            return findById(id).get();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException.getMessage());
        }
    }

    @Override
    public void deleteById(Integer id) {
        try {
            String sql = "delete from usuario where id = ?";
            PreparedStatement prepareStatement = getPrepareStatement(sql);
            prepareStatement.setInt(1, id);
            
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException.getMessage());
        }
    }

   
}
