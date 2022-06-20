package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.GuestBookService;
import com.javaex.vo.GuestBookVo;

@Controller
@RequestMapping("/guestbook")
public class GuestBookController {
	
	//필드
	@Autowired
	private GuestBookService guestbookService;
	
	//메소드 일반
	
	
	
	//addList
	@RequestMapping(value= "addList", method= {RequestMethod.GET, RequestMethod.POST})
	public String addList(Model model) {
		
		System.out.println("addList 진입");
		
		//리스트 만들기
		List<GuestBookVo> guestbookList = guestbookService.getGuestBookList();
		System.out.println(guestbookList);
		
		//ds통해서 attribute로 리스트 보내기
		model.addAttribute("guestbookList", guestbookList);
		
		
		return "guestbook/addList";
	}
	
	
	//add
	@RequestMapping(value= "add", method= {RequestMethod.GET, RequestMethod.POST})
	public String add(GuestBookVo guestbookVo) {
		System.out.println("add 진입");
		
		//service로 넣기
		guestbookService.insert(guestbookVo);
		
		//리다이렉트
		return "redirect:/addList";
	}
	
	
	//deleteForm
	@RequestMapping(value= "deleteForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String deleteForm(Model model, @RequestParam("no")int no) {
		System.out.println("deleteForm 진입");
		
		//no 보내주기
		model.addAttribute(no);
		
		return "guestbook/deleteForm";
	}
	
	
	//delete
	@RequestMapping(value= "delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(GuestBookVo guestbookVo) {
		System.out.println("delete 진입");
		
		//service로 삭제하기
		guestbookService.delete(guestbookVo);
		
		
		return "redirect:/addList";
	}
	
	
	

}



