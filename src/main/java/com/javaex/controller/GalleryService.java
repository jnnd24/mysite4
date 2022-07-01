package com.javaex.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.vo.GalleryVo;

@Service
public class GalleryService {
	
	
	public void upload(MultipartFile file, int userNo, String content) {
		System.out.println(" GalleryService > upload");
		
		//저장위치
		String saveDir = "C:\\javaStudy\\upload";
		
		//파일이름
		String orgName = file.getOriginalFilename();
		
		//확장자명
		String exName = orgName.substring(orgName.lastIndexOf("."));
		
		//저장파일명
		String saveName = System.currentTimeMillis()+UUID.randomUUID().toString()+exName;
		
		//파일경로
		String filePath = saveDir + saveName;
		
		//파일사이즈
		long fileSize = file.getSize();
		
		//vo로묶기
		GalleryVo galleryVo = new GalleryVo(userNo, content, filePath, orgName, saveName, fileSize);
		
		// 1. Dao로 보내서 저장하기
		
		
		// 2. 파일 저장하기
		
		try {
			byte[] fileData = file.getBytes();
			OutputStream os = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			
			bos.write(fileData);
			bos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
				
		
	}

}
