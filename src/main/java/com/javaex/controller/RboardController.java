package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.RboardService;
import com.javaex.vo.RboardVo;

@Controller
@RequestMapping(value="rboard")
public class RboardController {
	
	@Autowired
	private RboardService rboardService;
	
	
	@RequestMapping(value="list")
	public String read(Model model) {
		System.out.println(" RboardCtrl > read");
		
		List<RboardVo> rboardList = rboardService.getRboardList();
		System.out.println(rboardList);

		model.addAttribute("rboardList", rboardList);
		
		return "rboard/list";
	}
	
	
	//글 작성 폼
	@RequestMapping(value="writeForm")
	public String writeForm () {
		System.out.println(" RboardCtrl > writeForm");
		
		return "rboard/writeForm";
	}
	
	//글 작성
	@RequestMapping(value="write")
	public String write(@ModelAttribute RboardVo rboardVo) {
		System.out.println(" RboardCtrl > write");
		
		rboardService.write(rboardVo);
		
		return "redirect:list";
	}
	
	//글 읽기
	@RequestMapping(value="read")
	public String read(Model model,
						@RequestParam("no") int no) {
		System.out.println(" RboardCtrl > read");
		
		RboardVo getRboard = rboardService.read(no);
		
		//어트리뷰트로 보내기
		model.addAttribute("getRboard", getRboard);
		
		return "rboard/read";
	}
	
	//답글 작성 폼
	@RequestMapping(value="replyForm")
	public String replyForm(Model model, 
							@ModelAttribute RboardVo rboardVo){
		System.out.println(" RboardCtrl > replyForm");
		
		//groupNo, orderNo, depth 파라미터로 보내기
		model.addAttribute(rboardVo);
		
		return "rboard/replyForm";
	}
	
	//답글 작성
	@RequestMapping(value="reply")
	public String reply(@ModelAttribute RboardVo rboardVo) {
		System.out.println(" RboardCtrl > reply");
		
		System.out.println(rboardVo);
		
		rboardService.reply(rboardVo);
		
		return "redirect/list";
	}
	
	//수정 폼
	@RequestMapping(value="modifyForm")
	public String modifyForm(Model model, @RequestParam("no")int no) {
		System.out.println(" RboardCtrl > modifyForm");
		
		//no로 게시물 불러오기
		RboardVo getRboard = rboardService.read(no);
		
		//게시물내용 attribute로 넘기기
		model.addAttribute("getRboard", getRboard);
			
		return "rboard/modifyForm";
	}
	
	//수정
	@RequestMapping(value="modify")
	public String modify(RboardVo rboardVo) {
		System.out.println(" RboardCtrl > modify");
		
		System.out.println(rboardVo);
		
		//rboardService.update(rboardVo);
		
		return "";
	}
	
}
