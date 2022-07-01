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
	
	//메소드
	//리스트 가져오기
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
	public String delete(GuestBookVo guestbookVo) {
		
		int count = guestbookDao.delete(guestbookVo);
		
		String state;
		
		if (count>0) {
			state = "success";
		}else {
			state = "fail";
		}
		
		return state;
	}
	

}







