package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/gestion";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection connect() throws SQLException {
        // Charger le pilote JDBC
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException  e) {
            //e.printStackTrace();
        }
        finally{
        Connection connection=DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        // Retourner la connexion établie
        return  connection;}
    }
}
