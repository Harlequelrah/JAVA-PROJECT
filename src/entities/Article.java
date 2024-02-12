/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Maxime
 */
import java.util.Date;

public class Article {
    private int id_art;
    private int id_cat;
    private String libelle;
    private double prix;
    private int quantiteEnStock;
    private String  dateCreation;
    private int quantiteSeuil;
    private Categorie categorie;
    
    public Article(){
    }

   
    public Article(int id_art,int id_cat, String libelle, double prix, int quantiteSeuil) {
        this.id_art = id_art;
        this.id_cat = id_cat;
        this.libelle = libelle;
        this.prix = prix;
        this.quantiteEnStock = 0;
        this.dateCreation = getDateFormatted(); // Date actuelle
        this.quantiteSeuil = quantiteSeuil;
    }

    // Getters et Setters
    public int getId_Art() {
        return id_art;
    }

    public int getId_Cat() {
        return id_cat;
    }


    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getPrix() {
        return prix;
    }

    public void setId_Art(int id_art) {
        this.id_art = id_art;
    }

    public void setId_Cat(int id_cat) {
        this.id_cat = id_cat;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantiteEnStock() {
        return quantiteEnStock;
    }

    public void setQuantiteEnStock(int quantiteEnStock) {
        this.quantiteEnStock = quantiteEnStock;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public int getQuantiteSeuil() {
        return quantiteSeuil;
    }

    public void setQuantiteSeuil(int quantiteSeuil) {
        this.quantiteSeuil = quantiteSeuil;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
    
    public static String getDateFormatted() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return currentDate.format(formatter); // Date actuelle formatée
    }

    
}

