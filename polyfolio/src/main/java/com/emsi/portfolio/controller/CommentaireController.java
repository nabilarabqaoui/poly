package com.emsi.portfolio.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emsi.portfolio.service.CommentaireService;

import io.swagger.annotations.Api;

@Api("Cette end-point permet de gérer les commentaires")
@RestController
@RequestMapping("api/commentaire")
public class CommentaireController {
	final CommentaireService commentaireService ;
	
	public CommentaireController(CommentaireService commentaireService) {
		this.commentaireService = commentaireService;
	}
	

}
