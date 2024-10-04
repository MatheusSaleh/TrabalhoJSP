package fema3bccJsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistaDao {
	
	private String jdbcURL = "jdbc:h2:C:/FerramentasFema/crudcantor";

    private String jdbcUsername = "sa"; 
    private String jdbcPassword = ""; 
    
    private static final String INSERT_ARTISTA_SQL = "INSERT INTO cantor (nome, gravadora) VALUES (?, ?);";
    private static final String SELECT_ALL_ARTISTAS = "SELECT * FROM cantor;";
    private static final String DELETE_ARTISTA_SQL = "DELETE FROM cantor WHERE id = ?;";

    public void add(Artista artista) {
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ARTISTA_SQL)) {
            preparedStatement.setString(1, artista.getNome());
            preparedStatement.setString(2, artista.getGravadora());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Artista> getArtistas() {
        List<Artista> artistas = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ARTISTAS);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Artista artista = new Artista();
                artista.setCodigo(resultSet.getInt("id")); 
                artista.setNome(resultSet.getString("nome"));
                artista.setGravadora(resultSet.getString("gravadora"));
                artistas.add(artista);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return artistas;
    }
    
    
    public void excluir(Integer id) {
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ARTISTA_SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
