package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GalleryVo;

@Repository
public class GalleryDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int upload(GalleryVo galleryVo) {
		System.out.println(" GalleryDao > upload");
		
		System.out.println(galleryVo);
		
		int count = sqlSession.insert("gallery.upload", galleryVo);
		System.out.println(count + "건 저장완료");
		
		return count;
	}

}
