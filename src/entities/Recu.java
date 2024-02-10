/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author Maxime
 */
import java.util.Date;

public class Recu {
    final private int numeroRecu;
    final private String date;
    private Article articleVendu;
    private double montant;

    public Recu(int numeroRecu, Article articleVendu, double montant) {
        this.numeroRecu = numeroRecu;
        this.date = Article.getDateFormatted();
        this.articleVendu = articleVendu;
        this.montant = montant;
    }

    // Getters et Setters
    public int getNumeroRecu() {
        return numeroRecu;
    }

    public String getDate() {
        return date;
    }

    public Article getArticleVendu() {
        return articleVendu;
    }

    public void setArticleVendu(Article articleVendu) {
        this.articleVendu = articleVendu;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
}