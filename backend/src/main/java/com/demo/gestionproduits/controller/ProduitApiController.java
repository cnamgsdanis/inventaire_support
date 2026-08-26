package com.demo.gestionproduits.controller;

import com.demo.gestionproduits.model.Produit;
import com.demo.gestionproduits.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Le standardiste qui parle en JSON (pas en HTML)
@RestController
// Toutes les URLs de ce contrôleur commencent par /api/produits
@RequestMapping("/api/produits")
public class ProduitApiController {

    @Autowired
    private ProduitService produitService; // On réutilise le même cerveau (Service) !

    //  1. RECEVOIR la liste de tous les produits (GET)
    // URL : GET http://localhost:8080/api/produits
    @GetMapping
    public List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }

    //  2. RECEVOIR un seul produit par son ID (GET)
    // URL : GET http://localhost:8080/api/produits/1
    @GetMapping("/{id}")
    public ResponseEntity<Produit> getProduitById(@PathVariable Long id) {
        Produit produit = produitService.getProduitById(id);
        if (produit == null) {
            return ResponseEntity.notFound().build(); // 404 si pas trouvé
        }
        return ResponseEntity.ok(produit); // 200 + le produit en JSON
    }

    //  3. AJOUTER un nouveau produit (POST)
    // URL : POST http://localhost:8080/api/produits

    @PostMapping
    public ResponseEntity<Produit>updateProduit(@PathVariable Long id, @RequestBody Produit produitDetails){

        Produit existingProduit = produitService.getProduitById(id);
        if (existingProduit == null ){
            return ResponseEntity.notFound().build(); // 404
        }

        // on met à jour les champs

        existingProduit.setNom(produitDetails.getNom());
        existingProduit.setPrix(produitDetails.getPrix());
        existingProduit.setQuantite(produitDetails.getQuantite());

        produitService.saveProduit(existingProduit);
        return ResponseEntity.ok(existingProduit); //200 + le produit modifié
    }
}