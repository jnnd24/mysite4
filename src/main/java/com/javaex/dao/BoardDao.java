package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {
	
	//필드
	@Autowired
	private SqlSession sqlSession;
	
	//생성자
	
	//메소드gs
	
	//메소드
	
	//리스트불러오기
	public List<BoardVo> getBoardList() {
		System.out.println(" BoardDao > getBoardList");
		
		List<BoardVo> boardList = sqlSession.selectList("board.getBoardList");
		
		return boardList;
	}

	
	// 검색 리스트불러오기
	public List<BoardVo> getBoardList2(String keyword) {
		System.out.println(" BoardDao > getBoardList2");
		
		System.out.println(keyword);
		List<BoardVo> boardList = sqlSession.selectList("board.getBoardList2", keyword);
		System.out.println(boardList);
		
		return boardList;
	}
	
	// 검색 리스트불러오기 합치기
	public List<BoardVo> getBoardList3(String keyword) {
		System.out.println(" BoardDao > getBoardList3");
		
		System.out.println(keyword);
		List<BoardVo> boardList = sqlSession.selectList("board.getBoardList3", keyword);
		System.out.println(boardList);
		
		return boardList;
	}
	
	
	
	//조회수증가
	public int hitup(int no) {
		System.out.println(" BoardDao > hitup");
		
		int count = sqlSession.update("board.hitup", no);
		
		return count;
	}
	
	//게시물 불러오기
	public BoardVo getBoard(int no) {
		System.out.println(" BoardDao > getBoard");
		
		BoardVo getBoard = sqlSession.selectOne("board.getBoard", no);
		
		return getBoard;
	}
	
	//게시물 수정
	public int update(BoardVo boardVo) {
		System.out.println(" BoardDao > update");
		
		int count = sqlSession.update("board.update", boardVo);
		
		return count;
	}
	
	
	//게시물 등록
	public int write(BoardVo boardVo) {
		System.out.println(" BoardDao > write");
		
		int count = sqlSession.insert("board.write", boardVo);
		
		return count;
	}
	

}
