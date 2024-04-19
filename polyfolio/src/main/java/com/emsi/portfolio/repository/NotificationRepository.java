package com.emsi.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emsi.portfolio.model.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
