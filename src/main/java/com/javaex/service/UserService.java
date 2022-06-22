package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	
	//필드
	@Autowired
	private UserDao userDao;
	
	
	//메소드
	//회원가입
	public int insert(UserVo userVo) {
		System.out.println(" UserService > insert");
		
		int count = userDao.insert(userVo);
		
		return count;
		
	}
	
	//로그인 정보불러오기
	public UserVo getUser(UserVo userVo) {
		System.out.println(" UserService > getUser");

		UserVo authUser = userDao.getUser(userVo);
		
		return authUser;
	}
	
	
	//정보불러오기 수정용
	public UserVo getUser(int no) {
		System.out.println(" UserService > getUser");
		
		UserVo userVo = userDao.getUser(no);
		
		return userVo;
	}
	
	//회원정보 수정
	public int update(UserVo userVo) {
		
		int count = userDao.update(userVo);
		
		return count;
	}
	
	

}
