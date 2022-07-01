package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("gallery")
public class GalleryController {

	@Autowired
	private GalleryService galleryService;
	
	
	@RequestMapping(value="list")
	public String list() {
		System.out.println(" GalleryCtrl > list");
		
		
		
		return "gallery/list";
	};
	
	
	@RequestMapping(value="upload", method= {RequestMethod.GET, RequestMethod.POST})
	public String upload(@RequestParam("file") MultipartFile file, 
						@RequestParam("userNo")int userNo, 
						@RequestParam("content")String content) {
		System.out.println(" GalleryCtrl > upload");
		
		galleryService.upload(file, userNo, content);
		
		
		return "";
	}
	
}
