package com.emsi.portfolio.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emsi.portfolio.service.EvenementService;

import io.swagger.annotations.Api;

@Api("Cette end-point permet de gérer les Evenements")
@RestController
@RequestMapping("api/evenement")
public class EvenementController {
	final EvenementService evenementService ;
	
	public EvenementController(EvenementService evenementService) {
		this.evenementService = evenementService;
	}
	

}
