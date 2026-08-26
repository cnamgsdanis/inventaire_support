package com.demo.gestionproduits.controller;

import com.demo.gestionproduits.model.Produit;
import com.demo.gestionproduits.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller // C'est le serveur qui prend les commandes (URL)
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    // Afficher la liste des produits (page d'accueil)
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listeProduits", produitService.getAllProduits());
        return "index"; // On va créer un fichier index.html
    }

    // Afficher le formulaire pour AJOUTER un produit
    @GetMapping("/ajouter")
    public String showAddForm(Model model) {
        model.addAttribute("produit", new Produit());
        return "formulaire"; // On va créer un fichier formulaire.html
    }

    // Enregistrer (ajout ou modification)
    @PostMapping("/sauvegarder")
    public String saveProduit(@ModelAttribute Produit produit) {
        produitService.saveProduit(produit);
        return "redirect:/"; // Retourne à la liste
    }

    // Afficher le formulaire pour MODIFIER un produit
    @GetMapping("/modifier/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("produit", produitService.getProduitById(id));
        return "formulaire";
    }

    // Supprimer un produit
    @GetMapping("/supprimer/{id}")
    public String deleteProduit(@PathVariable Long id) {
        produitService.deleteProduit(id);
        return "redirect:/";
    }
}