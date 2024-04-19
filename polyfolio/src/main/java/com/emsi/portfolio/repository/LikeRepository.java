package com.emsi.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emsi.portfolio.model.Like;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {

}
