package com.emsi.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emsi.portfolio.model.Formation;

@Repository
public interface FormationRepository extends JpaRepository<Formation, Long> {

}
