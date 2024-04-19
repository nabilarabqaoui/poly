package com.emsi.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emsi.portfolio.model.Media;

@Repository
public interface MediaRepository extends JpaRepository<Media, Long> {

}
