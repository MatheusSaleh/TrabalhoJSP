package fema3bccJsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnection {
    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection("jdbc:h2:file:C:/FerramentasFema/crudcantor;IFEXISTS=FALSE", "sa", "");

        String createTableSQL = "CREATE TABLE IF NOT EXISTS cantor ("
                + "id INT PRIMARY KEY AUTO_INCREMENT, "
                + "nome VARCHAR(255), "
                + "gravadora VARCHAR(255))";
        
        String createTableAlbum = "CREATE TABLE IF NOT EXISTS album ("
        		+ "id INT PRIMARY KEY AUTO_INCREMENT,"
        		+ "nome VARCHAR(255))";
        
        String createTableMusica = "CREATE TABLE IF NOT EXISTS musica ("
        		+ "id INT PRIMARY KEY AUTO_INCREMENT,"
        		+ "nome VARCHAR(255))"; 

        Statement statement = connection.createStatement();
        statement.execute(createTableSQL);
        statement.execute(createTableAlbum);
        statement.execute(createTableMusica);
        
        return connection;
    }
}
