package com.demo.gestionproduits.repository;

import com.demo.gestionproduits.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // C'est le standardiste qui appelle la base
public interface ProduitRepository extends JpaRepository<Produit, Long> {
    // Ici, on n'écrit RIEN ! Spring écrit tout tout seul (trouver, sauvegarder, supprimer...)
}