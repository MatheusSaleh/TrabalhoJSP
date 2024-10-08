package fema3bccJsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MusicaDao {
	private String jdbcURL = "jdbc:h2:C:/FerramentasFema/crudcantor";

    private String jdbcUsername = "sa"; 
    private String jdbcPassword = ""; 
    
    private static final String INSERT_MUSICA_SQL = "INSERT INTO musica (nome) VALUES (?);";
    private static final String SELECT_ALL_MUSICA = "SELECT * FROM musica;";
    private static final String DELETE_MUSICA_SQL = "DELETE FROM musica WHERE id = ?;";
    
    public void add(Musica musica) {
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MUSICA_SQL)) {
            preparedStatement.setString(1, musica.getNome());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Musica> getMusicas() {
        List<Musica> musicas = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MUSICA);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
            	Musica musica = new Musica();
            	musica.setCodigo(resultSet.getInt("id")); 
            	musica.setNome(resultSet.getString("nome"));
            	musicas.add(musica);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return musicas;
    }
    
    public void excluir(Integer id) {
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_MUSICA_SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}
