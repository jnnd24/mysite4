package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	
	//필드 
	@Autowired
	private BoardService boardService;
	
	//메소드
	@RequestMapping(value= "list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println(" BoardCtrl > list");
		
		//리스트가져오기
		List<BoardVo> boardList = boardService.getBoardList();
		
		model.addAttribute("boardList", boardList);
		System.out.println(boardList);
		
		return "board/list";
	}
	
	//보기
	@RequestMapping(value= "read", method= {RequestMethod.GET, RequestMethod.POST})
	public String read(Model model, @RequestParam("no")int no) {
		System.out.println(" BoardCtrl > read");
		
		//조회수 올리기
		boardService.hitup(no);
		
		//게시판 불러오기
		BoardVo getBoard = boardService.getboard(no);
		model.addAttribute("getBoard", getBoard);
		
		return "board/read";
	}
	
	
	//수정폼
	@RequestMapping(value= "modifyForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm(Model model, @RequestParam("no")int no) {
		System.out.println(" BoardCtrl > modifyForm");

		BoardVo getBoard = boardService.getboard(no);
		model.addAttribute("getBoard", getBoard);
		
		return "board/modifyForm";
	}
	
	
	//수정
	@RequestMapping(value= "modify", method= {RequestMethod.GET, RequestMethod.POST})
	public String modify(@ModelAttribute BoardVo boardVo) {
		System.out.println(" BoardCtrl > modify");
		
		boardService.update(boardVo);
		
		return "redirect:list";
	}
	
	
	
	

}
