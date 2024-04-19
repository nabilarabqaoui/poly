package com.emsi.portfolio.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emsi.portfolio.model.ERole;
import com.emsi.portfolio.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
Role findByName(ERole name);
}
