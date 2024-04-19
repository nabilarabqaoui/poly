package com.emsi.portfolio.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emsi.portfolio.service.MediaService;

import io.swagger.annotations.Api;

@Api("Cette end-point permet de gérer les medias")
@RestController
@RequestMapping("api/media")
public class MediaController {
	final MediaService mediaService ;
	
	public MediaController(MediaService mediaService) {
		this.mediaService = mediaService;
	}
	

}
