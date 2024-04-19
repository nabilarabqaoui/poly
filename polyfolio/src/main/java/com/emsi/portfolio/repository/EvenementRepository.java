package com.emsi.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emsi.portfolio.model.Evenement;


@Repository
public interface EvenementRepository extends JpaRepository<Evenement, Long> {

}
