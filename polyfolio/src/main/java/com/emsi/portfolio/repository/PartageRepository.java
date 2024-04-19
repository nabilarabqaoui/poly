package com.emsi.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emsi.portfolio.model.Partage;

@Repository
public interface PartageRepository extends JpaRepository<Partage, Long> {

}
