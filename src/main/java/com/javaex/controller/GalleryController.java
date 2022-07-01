package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("gallery")
public class GalleryController {

	
	
	@RequestMapping(value="list")
	public String list() {
		System.out.println(" GalleryCtrl > list");
		
		
		
		return "gallery/list";
	};
	
	
	@RequestMapping("upload")
	public String upload(@RequestParam("file") MultipartFile file) {
		System.out.println(" GalleryCtrl > upload");
		
		
		
		
		return "";
	}
	
}
