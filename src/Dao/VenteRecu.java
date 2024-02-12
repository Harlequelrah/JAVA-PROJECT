package Dao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import entities.User;
import entities.Article;
import java.sql.Connection;
import java.sql.SQLException;
import Dao.DatabaseConnection;
import java.sql.ResultSet;
import Dao.ArticleDao;
import java.sql.Statement;


import java.sql.PreparedStatement;
/**
 *
 * @author Maxime
 */
import java.util.ArrayList;
import java.util.List;

public class VenteRecu {
    
    public static boolean Vendre(Article article,int qtevendu)throws SQLException{
        if(article.getQuantiteEnStock()<1){return false;}
       boolean retour = false;
        String date_vente=Article.getDateFormatted();
        Connection con =DatabaseConnection.connect();
        PreparedStatement ps = con.prepareStatement("insert into vente(id_art,quantite_vendue,date_vente) values (?,?,?)");
        ps.setInt(1, article.getId_Art());
        ps.setInt(2, qtevendu);
        ps.setString(3,date_vente);
        if(ps.executeUpdate()==1){
            retour =true;
        }

        Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("SELECT LAST_INSERT_ID()");
int id_vente=0;
if (rs.next()) {
    id_vente = rs.getInt(1);
}
rs.close();
stmt.close();
        PreparedStatement ps2=con.prepareStatement("insert into reçu(id_art,id_vente,quantite_vendue,montant,date_vente) values(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        ps2.setInt(1,article.getId_Art());
        ps2.setInt(2, id_vente);
        ps2.setInt(3, qtevendu);
        ps2.setDouble(4,qtevendu*article.getPrix());
        ps2.setString(5,date_vente);
        boolean retour2=false;
        if(ps2.executeUpdate()==1){retour2 =true;}
        PreparedStatement ps3=con.prepareStatement("Update article set quantite_en_stock=? where id_art=? ");
        ps3.setInt(1,article.getQuantiteEnStock()- qtevendu);
        ps3.setInt(2,article.getId_Art());
        boolean retour3=false;
        if(ps3.executeUpdate()==1){retour3=true;}
        //rs.close();
        
        ps.close();
        ps2.close();
        ps3.close();
        con.close();
        boolean endretour=false;
        if (retour && retour2 && retour3){ endretour=true;
        }return endretour;
    }
       public static void main(String [] args)throws SQLException{
           Article article = new Article(1,1,"tasse de cafe sukuna",5.99,10);
           //ArticleDao.CreateArticle(article);
           Vendre(article,3);
       }
    // Autres méthodes à implémenter...
}