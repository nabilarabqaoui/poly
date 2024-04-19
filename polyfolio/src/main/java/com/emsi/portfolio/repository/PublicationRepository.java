package com.emsi.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emsi.portfolio.model.Publication;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {

}
