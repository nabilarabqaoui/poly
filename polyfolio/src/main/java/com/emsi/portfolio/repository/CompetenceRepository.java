package com.emsi.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emsi.portfolio.model.Competence;

@Repository
public interface CompetenceRepository extends JpaRepository<Competence, Long> {

}
