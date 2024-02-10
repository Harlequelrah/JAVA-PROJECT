package Dao;
import java.sql.Connection;
import java.sql.SQLException;
import Dao.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import entities.Article;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import entities.Article;
import java.util.Map;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Maxime
 */


public class ArticleDao {
    
       public static int CreateArticle(Article article) throws SQLException{
         //Ouverture de la connexion à la BD
        Connection con = DatabaseConnection.connect();
        int retour = 0;
        
        String insertArticleSql = "INSERT INTO article(libelle, prix, qteEnStock, dateCreation, qteSeuil) VALUES(?, ?, 0, ?, ?, ?)";
        
        PreparedStatement ps = null;
        
        ps = con.prepareStatement(insertArticleSql);
        
        ps.setInt(1, article.getId_Art());
        ps.setInt(2, article.getId_Cat());
        ps.setString(3, article.getLibelle());
        ps.setDouble(4, article.getPrix());
        ps.setInt(5, article.getQuantiteEnStock());
        ps.setString(6, article.getDateCreation());
        ps.setInt(7, article.getQuantiteSeuil());
   
        
        retour = ps.executeUpdate();
        ps.close();
        con.close();
        
        return retour;
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public List<Map<String, Object>>  LsArtCat()throws SQLException{
        Connection con = DatabaseConnection.connect();
        String query="SELECT article.id_art as id ,"+
"    article.libelle ," +
"    article.prix ," +
"    article.quantite_en_stock ," +
"    article.date_creation ," +
"    article.quantite_seuil ," +
"    categorie.designation ," +
"FROM " +
"    article" +
"INNER JOIN " +
"    categorie ON article.id_cat = categorie.id_cat";
                
        PreparedStatement ps=con.prepareStatement(query);
        ResultSet rs= ps.executeQuery();
        List<Map<String, Object>> resultat=HelpDao.convertResultSetToMapList(rs);
        rs.close();
        ps.close();
        con.close();
        return resultat;
        
    }
   

    
}

    // Autres méthodes à implémenter...
