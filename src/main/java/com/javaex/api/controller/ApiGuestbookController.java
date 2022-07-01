package com.javaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.GuestBookService;
import com.javaex.vo.GuestBookVo;

@Controller
public class ApiGuestbookController {
	
	@Autowired
	private GuestBookService guestbookService;
	
	
	@RequestMapping(value="api/guestbook/addList", method= {RequestMethod.GET, RequestMethod.POST})
	public String addList() {
		System.out.println(" ApiGBC > addList");
		
		return "apiGuestbook/addList";
	}
	
	//데이터보니주기
	@ResponseBody
	@RequestMapping(value="api/guestbook/list", method= {RequestMethod.GET, RequestMethod.POST})
	public List<GuestBookVo> list() {
		System.out.println(" ApiGBC > list");

		List<GuestBookVo> guestbookList = guestbookService.getGuestBookList();
		System.out.println(guestbookList);

		return guestbookList;
	}
	
	//저장
	@ResponseBody
	@RequestMapping(value="api/guestbook/add", method= {RequestMethod.GET, RequestMethod.POST})
	public String add(@ModelAttribute GuestBookVo guestbookVo) {
		System.out.println(" ApiGBC > add");
		
		System.out.println(guestbookVo);
		guestbookService.insert(guestbookVo);
		
		return "";
	}
	
	//삭제
	@ResponseBody
	@RequestMapping(value="api/guestbook/remove")
	public String remove(@ModelAttribute GuestBookVo guestbookVo) {
		System.out.println(" apiGBC > remove");
		
		String state = guestbookService.delete(guestbookVo);
		
		System.out.println(state);
		return state;
	}
	
	

}
