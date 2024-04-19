package com.emsi.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emsi.portfolio.model.Commentaire;
import com.emsi.portfolio.model.Utilisateur;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {

}
