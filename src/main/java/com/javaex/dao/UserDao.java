package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	
	//필드
	@Autowired
	private SqlSession sqlSession;
	
	//생성자
	
	//gs
	
	//메소드
	
	
	// 회원가입
	public int insert(UserVo userVo) {
		System.out.println(" UserDao > insert");
		
		int count = sqlSession.insert("user.insert", userVo);
		
		return count;
	}
	
	
	//유저정보불러오기 로그인용
	public UserVo getUser(UserVo userVo) {
		System.out.println(" UserDao > getUser");

		UserVo authUser = sqlSession.selectOne("user.getUser", userVo);
		
		return authUser;
	}
	
	//정보불러오기 수정용
	public UserVo getUser(int no) {
		System.out.println(" UserDao > getUser");
		
		System.out.println(no);
		
		UserVo userVo = sqlSession.selectOne("user.getLoginUser", no);
		
		return userVo;
	}
	
	//회원정보 수정
	public int update(UserVo userVo) {
		System.out.println(" UserDao > update");
		
		System.out.println(userVo);
		int count = sqlSession.update("user.userUpdate", userVo);
		
		return count;
	}
	
	

}
