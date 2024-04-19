package com.emsi.portfolio.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emsi.portfolio.service.NotificationService;

import io.swagger.annotations.Api;

@Api("Cette end-point permet de gérer les Notifications")
@RestController
@RequestMapping("api/notification")
public class NotificationController {
	final NotificationService notificationService ;
	
	public NotificationController(NotificationService notificationService) {
		this.notificationService = notificationService;
	}
	

}
