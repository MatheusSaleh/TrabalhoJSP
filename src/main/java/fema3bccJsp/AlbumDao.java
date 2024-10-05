package fema3bccJsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlbumDao {
	private String jdbcURL = "jdbc:h2:C:/FerramentasFema/crudcantor";

    private String jdbcUsername = "sa"; 
    private String jdbcPassword = ""; 
    
    private static final String INSERT_ALBUM_SQL = "INSERT INTO album (nome) VALUES (?);";
    private static final String SELECT_ALL_ALBUM = "SELECT * FROM album;";
    private static final String DELETE_ALBUM_SQL = "DELETE FROM album WHERE id = ?;";
    
    public void add(Album album) {
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ALBUM_SQL)) {
            preparedStatement.setString(1, album.getNome());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Album> getAlbuns() {
        List<Album> albuns = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ALBUM);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Album album = new Album();
                album.setCodigo(resultSet.getInt("id")); 
                album.setNome(resultSet.getString("nome"));
                albuns.add(album);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return albuns;
    }
    
    public void excluir(Integer id) {
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ALBUM_SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
