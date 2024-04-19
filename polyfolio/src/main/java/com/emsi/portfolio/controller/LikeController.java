package com.emsi.portfolio.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emsi.portfolio.service.LikeService;

import io.swagger.annotations.Api;

@Api("Cette end-point permet de gérer les likes")
@RestController
@RequestMapping("api/like")
public class LikeController {
	final LikeService likeService ;
	
	public LikeController(LikeService likeService) {
		this.likeService = likeService;
	}
	

}
