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
     public static int deleteArticle(Article article) throws SQLException{
        int retour =0;
        Connection con = DatabaseConnection.connect();

        String deleteArticle = "DELETE FROM article where id = ?";

        PreparedStatement ps = null;
        ps = con.prepareStatement(deleteArticle);

        ps.setInt(1, article.getId_Art());

        retour = ps.executeUpdate();

        return retour;
    }
    public static int updateArticle(int id) throws SQLException{
        int retour = 0;
        Connection con = DatabaseConnection.connect();

        String updateArticle = "UPDATE article SET id_cat = ?, libelle = ?, prix = ?, qteEnStock=?, dateCreation=?, qteSeuil=? WHERE id= ?";
         PreparedStatement ps = null;

         ps = con.prepareStatement(updateArticle);

         ps.setInt(1, id);

        retour = ps.executeUpdate();
        return retour;
    }
    public static int findArticle(int id) throws SQLException{
        int retour =0;
        Connection con =DatabaseConnection.connect();
        String findArticle = "SELECT * FROM article where id=?";
        PreparedStatement ps = null;
        ps = con.prepareStatement(findArticle);
        ps.setInt(1, id);
        retour = ps.executeUpdate();
        return retour;
    }
    public static List<ArticleCat> ArticleList() throws SQLException{
        List<ArticleCat> articles = new ArrayList<>();
        int retour = 0;
        Connection con = DatabaseConnection.connect();
        String articleList = "SELECT a.id, libelle, id_cat, designation, prix, dateCreation, qteEnStock, qteSeuil FROM article a INNER JOIN categorie c ON a.id_cat = c.id ";
        PreparedStatement ps = null;
        ps = con.prepareStatement(articleList);
        ResultSet rs = null;
        rs = ps.executeQuery();
        while(rs.next()){
            ArticleCat article = new ArticleCat();
            article.setId_Art(rs.getInt("a.id"));
            article.setLibelle(rs.getString("libelle"));
            article.setId_Cat(rs.getInt("id_cat"));
            article.setDesignation(rs.getString("designation"));
            article.setPrix(rs.getDouble("prix"));
            article.setDateCreation(rs.getString("dateCreation"));
            article.setQuantiteEnStock(rs.getInt("qteEnStock"));
            article.setQuantiteSeuil(rs.getInt("qteSeuil"));

            articles.add(article);
    }
        return articles;
    }

    public static class ArticleCat extends Article {
        private String designation;

        public ArticleCat() {
        }

        public ArticleCat(String designation) {
            this.designation = designation;
        }

        public ArticleCat( int id_art, String libelle, int id_cat, String designation, double prix,String dateCreation, int quantiteEnStock,  int quantiteSeuil) {
            super(id_art, id_cat, libelle, prix,quantiteSeuil);
            this.designation = designation;
        }

        public String getDesignation() {
            return designation;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }


    }
   

    
}

    // Autres méthodes à implémenter...
