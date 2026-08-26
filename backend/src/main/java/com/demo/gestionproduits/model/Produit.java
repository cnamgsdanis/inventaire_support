package com.demo.gestionproduits.model;

import jakarta.persistence.*;

@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // ICI : "strategy" avec un "r" et "GenerationType" avec un "e"
    private Long id;

    private String nom;
    private double prix;
    private int quantite;

    // Constructeur vide
    public Produit() {
    }

    // Constructeur avec paramètres
    public Produit(String nom, double prix, int quantite) {
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;   // ICI : "quantite" (sans accent, comme la variable)
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}