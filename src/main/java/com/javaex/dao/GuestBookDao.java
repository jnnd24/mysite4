package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestBookVo;

@Repository
public class GuestBookDao {
	
	
	//필드
	@Autowired
	private SqlSession sqlSession;


	//생성자
	
	//메소드gs
	
	
	//메소드 일반
	//리스트 불러오기
	public List<GuestBookVo> getGuestBookList(){
		System.out.println("Dao > getGBLS");
		List<GuestBookVo> guestbookList = sqlSession.selectList("guestbook.getGuestBookList");
		System.out.println("dao" + guestbookList.toString());
		return guestbookList;
	}
	
	
	//방멸록 등록
	public int insert(GuestBookVo guestbookVo) {
		System.out.println(" GBDao > insert");
		
		System.out.println(guestbookVo);
		int count = sqlSession.insert("guestbook.insert", guestbookVo);
		
		return count;
	}
	
	
	//방명록 삭제
	public int delete(GuestBookVo guestbookVo) {
		System.out.println(" GBDao > delete");
		
		int count = sqlSession.delete("guestbook.delete", guestbookVo);
		
		return count;
	}
	
	
}
