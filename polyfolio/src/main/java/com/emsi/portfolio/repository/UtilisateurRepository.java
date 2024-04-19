package com.emsi.portfolio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emsi.portfolio.model.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
Optional<Utilisateur> findByUsername(String username);
Optional<Utilisateur> findByEmail(String email);
Boolean existsByUsername(String username);
Boolean existsByTelephone(String telephone);
Boolean existsByEmail(String email);
}
