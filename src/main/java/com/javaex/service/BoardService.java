package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {
	
	//필드
	@Autowired
	private BoardDao boardDao;
	
	//메소드
	
	
	//리스트가져오기
	public List<BoardVo> getBoardList() {
		System.out.println(" boardServic > getBoardList");
		
		List<BoardVo> boardList = boardDao.getBoardList();
		
		return boardList;
	}
	
	//검색 리스트가져오기
	public List<BoardVo> getBoardList2(String keyword) {
		System.out.println(" boardServic > getBoardList2");
		
		List<BoardVo> boardList = boardDao.getBoardList2(keyword);
		
		return boardList;
	}
	
	//검색 리스트가져오기 합치기
	public List<BoardVo> getBoardList3(String keyword) {
		System.out.println(" boardServic > getBoardList2");
		
		List<BoardVo> boardList = boardDao.getBoardList3(keyword);
		
		return boardList;
	}
	
	//조회수 올리기
	public int hitup(int no) {
		System.out.println(" boardService > hitup");
		
		int count = boardDao.hitup(no);
		
		return count;
	}
	
	//게시물 불러오기
	public BoardVo getboard(int no) {
		
		BoardVo getBoard = boardDao.getBoard(no);
		
		return getBoard;
	}
	
	//게시물 수정
	public int update(BoardVo boardVo) {

		int count = boardDao.update(boardVo);
		
		return count;
	}
	
	//게시물 등록
	public int write(BoardVo boardVo) {
		System.out.println(" BoardService > write");
		
		int count = boardDao.write(boardVo);
		
		return count;
	}
	

}
