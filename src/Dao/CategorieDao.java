/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import java.sql.Connection;
import java.sql.SQLException;
import Dao.DatabaseConnection;
import java.sql.ResultSet;
import entities.Categorie;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Dao.DatabaseConnection;
/**
 *
 * @author Maxime
 */
public class CategorieDao {
    public static int CreateCategorie(Categorie cat) throws SQLException{
       Connection con = DatabaseConnection.connect();
        int retour = 0;
        
       String insertCatSql = "INSERT INTO categorie(designation) values(?)";
       
       PreparedStatement ps = null;
        
        ps = con.prepareStatement(insertCatSql);
        
        ps.setString(1, cat.getDesignation());
        
        retour = ps.executeUpdate();
        
        return retour;
    }
}
