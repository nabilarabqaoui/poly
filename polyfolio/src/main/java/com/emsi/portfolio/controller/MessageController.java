package com.emsi.portfolio.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emsi.portfolio.service.MessageService;

import io.swagger.annotations.Api;

@Api("Cette end-point permet de gérer les messages")
@RestController
@RequestMapping("api/message")
public class MessageController {
	final MessageService messageService ;
	
	public MessageController(MessageService messageService) {
		this.messageService = messageService;
	}
	

}
