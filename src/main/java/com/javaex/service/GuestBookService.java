package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestBookDao;
import com.javaex.vo.GuestBookVo;

@Service
public class GuestBookService {
	
	//필드
	@Autowired
	private GuestBookDao guestbookDao;
	
	
	public List<GuestBookVo> getGuestBookList(){
		
		List<GuestBookVo> guestbookList = guestbookDao.getGuestBookList();
		
		return guestbookList;
	}
	
	
	//입력
	public int insert(GuestBookVo guestbookVo) {
		
		int count = guestbookDao.insert(guestbookVo);
		
		return count;
	}
	
	
	//삭제
	public int delete(GuestBookVo guestbookVo) {
		
		int count = guestbookDao.delete(guestbookVo);
		
		return count;
	}
	

}







