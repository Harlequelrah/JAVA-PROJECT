/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import entities.User;
import java.sql.Connection;
import java.sql.SQLException;
import Dao.DatabaseConnection;
import java.sql.ResultSet;

import java.sql.PreparedStatement;

/**
 *
 * @author Maxime
 */
public class UserDao {
    public static boolean ExistUser(String username) throws SQLException{
        boolean retour =false;
        Connection con =DatabaseConnection.connect();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM utilisateur where username=?");
        ps.setString(1, username);
        ResultSet rs=ps.executeQuery();
        if (rs.next()){
            retour=true;
        }
        rs.close();
        ps.close();
        con.close();
        return retour;
    }
    public static boolean Authentification(String username , String password)throws SQLException{
        boolean retour=false;
        Connection con=DatabaseConnection.connect();
        PreparedStatement ps= con.prepareStatement("SELECT * FROM utilisateur where username=? and password=?");
        ps.setString(1,username);
        ps.setString(2,password);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            retour=true;
        }
        rs.close();
        ps.close();
        con.close();
        return retour;
        
    
}
    public static void main(String [] args )throws SQLException{
        boolean a=ExistUser("Harlequin");
        boolean b=Authentification("harlequin","@Lucibel1");
        System.out.println(b);
    }
    

    
}
