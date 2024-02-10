/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author Maxime
 */
public class Categorie {
    final private int id_cat;
    private String designation;
    
    public Categorie(){
    
    }
    public Categorie(int id_cat, String designation) {
        this.id_cat = id_cat;
        this.designation = designation;
    }

    // Getters et Setters
    public int getId_Cat() {
        return id_cat;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
