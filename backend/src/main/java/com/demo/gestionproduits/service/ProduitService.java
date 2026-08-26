package com.demo.gestionproduits.service;

import com.demo.gestionproduits.model.Produit;
import com.demo.gestionproduits.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // C'est le chef cuisinier
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository; // Le chef parle au standardiste

    // Voir tous les produits
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    // Voir un seul produit par son id
    public Produit getProduitById(Long id) {
        return produitRepository.findById(id).orElse(null);
    }

    // Ajouter ou modifier un produit
    public void saveProduit(Produit produit) {
        produitRepository.save(produit);
    }

    // Supprimer un produit
    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }
}