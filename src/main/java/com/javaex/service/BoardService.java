package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {

	// 필드
	@Autowired
	private BoardDao boardDao;

	// 메소드

	// 리스트(일반) - 페이징
	public List<BoardVo> getBoardList4(int crtPage) {
		System.out.println(" boardServic > getBoardList4");

		//사망연산자
		crtPage = (crtPage > 0) ? crtPage : (crtPage = 1);
		
		//페이지당 글 갯수
		int listCnt = 10;
		
		//시작,끝글번호
		int startRnum = (crtPage-1)*listCnt + 1;
		int endRnum = startRnum + listCnt - 1;
		
		List<BoardVo> boardList = boardDao.getBoardList4(startRnum, endRnum);
		
		
		//전체글갯수
		int totalCnt = boardDao.selectTotalCnt();
		
		//버튼갯수
		int pageBtnCount = 5;
		
		//마지막페이지
		int endPageBtnNo = (int) (Math.ceil(crtPage/(double)pageBtnCount)*pageBtnCount);
		
		//시작페이지
		int startPageBtnNo = endPageBtnNo-pageBtnCount  + 1;
		
		//다음 화살표 유유
		boolean next = false;
		if(listCnt*endPageBtnNo < totalCnt) {
			next = true;
		}
		
		//이전 화살표 유무
		boolean prev = false;
		if(startPageBtnNo != 1) {
			prev = true;
		}
		
		System.out.println(crtPage);
		System.out.println(prev + "," + startPageBtnNo + "," +endPageBtnNo + "," + next);
		
		return boardList;
	}

	// 리스트가져오기
	public List<BoardVo> getBoardList() {
		System.out.println(" boardServic > getBoardList");

		List<BoardVo> boardList = boardDao.getBoardList();

		return boardList;
	}

	// 검색 리스트가져오기
	public List<BoardVo> getBoardList2(String keyword) {
		System.out.println(" boardServic > getBoardList2");

		List<BoardVo> boardList = boardDao.getBoardList2(keyword);

		return boardList;
	}

	// 검색 리스트가져오기 합치기
	public List<BoardVo> getBoardList3(String keyword) {
		System.out.println(" boardServic > getBoardList2");

		List<BoardVo> boardList = boardDao.getBoardList3(keyword);

		return boardList;
	}

	// 조회수 올리기
	public int hitup(int no) {
		System.out.println(" boardService > hitup");

		int count = boardDao.hitup(no);

		return count;
	}

	// 게시물 불러오기
	public BoardVo getboard(int no) {

		BoardVo getBoard = boardDao.getBoard(no);

		return getBoard;
	}

	// 게시물 수정
	public int update(BoardVo boardVo) {

		int count = boardDao.update(boardVo);

		return count;
	}

	// 게시물 등록
	public int write(BoardVo boardVo) {
		System.out.println(" BoardService > write");

		return boardDao.write(boardVo);
	}

}
