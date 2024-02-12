/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author Maxime
 */
import entities.Article;
import java.sql.Connection;
import java.sql.SQLException;
import Dao.DatabaseConnection;
import java.sql.ResultSet;

import java.sql.PreparedStatement;

public class Approvisionnement {
    public static boolean Approvisionner(Article article,int qteapp)throws SQLException{
        boolean retour = false;
        Connection con = DatabaseConnection.connect();
        PreparedStatement ps =null;
        try{
             ps = con.prepareStatement("update article set quantite_en_stock=? where id_art=?");
             ps.setInt(1,article.getQuantiteEnStock()+ qteapp);
             ps.setInt(2, article.getId_Art());
             if(ps.executeUpdate()==1){retour=true;}
        }
        finally {
        // Fermer la connexion et le PreparedStatement
            if (ps != null) {
               ps.close();
            }
            if (con != null) {
             con.close();
            }
        }
    
        return retour;   
    }
    
    // Autres méthodes à implémenter...
}