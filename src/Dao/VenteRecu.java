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

import java.sql.PreparedStatement;
/**
 *
 * @author Maxime
 */
import java.util.ArrayList;
import java.util.List;

public class VenteRecu {
    
    public static boolean Vendre(Article article,int qtevendu)throws SQLException{
       boolean retour = false;
        String date_vente=Article.getDateFormatted();
        Connection con =DatabaseConnection.connect();
        PreparedStatement ps = con.prepareStatement("insert into vente(quantite_vendue,date_vente,id_art) values (?,?,?)");
        ps.setInt(1, qtevendu);
        ps.setString(2,date_vente);
        ps.setInt(3, article.getId_Art());
        ps.executeUpdate();
        ResultSet rs =ps.getResultSet();
        int id_vente=rs.getInt("id_vente");
        PreparedStatement ps2=con.prepareStatement("insert into reçu(quantite_vendu,montant,date_vente,id_vente) values(?,?,?,?)");
        ps2.setInt(1, qtevendu);
        ps2.setDouble(2,qtevendu*article.getPrix());
        ps2.setString(3,date_vente);
        ps2.setInt(4, id_vente);
        ps2.executeUpdate();
        PreparedStatement ps3=con.prepareStatement("Update article set quantite_en_stock=? where id_art=? ");
        ps3.setInt(1,article.getQuantiteEnStock()- qtevendu);
        ps3.setInt(2,article.getId_Art());
        ps3.executeUpdate();
        rs.close();
        ps.close();
        ps2.close();
        ps3.close();
        con.close();
        retour=true;
        return retour;
    }
       
    // Autres méthodes à implémenter...
}