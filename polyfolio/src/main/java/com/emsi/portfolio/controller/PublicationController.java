package com.emsi.portfolio.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emsi.portfolio.service.PublicationService;

import io.swagger.annotations.Api;

@Api("Cette end-point permet de gérer les publications")
@RestController
@RequestMapping("api/publication")
public class PublicationController {
	final PublicationService publicationService ;
	
	public PublicationController(PublicationService publicationService) {
		this.publicationService = publicationService;
	}
	

}
