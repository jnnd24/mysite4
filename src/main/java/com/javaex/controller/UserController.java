package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	//필드
	@Autowired
	UserService userService;
	
	//생성자
	
	//메소드 gs
	
	//메소드 일반
	//회원가입 폼
	@RequestMapping(value="joinForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String joinForm() {
		System.out.println(" UserCtrl > joinForm");
		
		return "user/joinForm";
	}
	
	//회원가입
	@RequestMapping(value="join", method= {RequestMethod.GET, RequestMethod.POST})
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println(" UserCtrl > Join");
		
		userService.insert(userVo);
		
		return "user/joinOk";
	}
	
	//로그인 폼
	@RequestMapping(value="loginForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String loginForm() {
		System.out.println(" UserCtrl > loginForm");
		
		return "user/loginForm";
	}
	
	//로그인
	@RequestMapping(value="login", method= {RequestMethod.GET, RequestMethod.POST})
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println(" UserCtrl > login");
		
		//세션 등록
		UserVo authUser = userService.getUser(userVo);
		
		if(authUser != null) {
			session.setAttribute("authUser", authUser);
			System.out.println("로그인 성공");
			
			return "redirect:/main";
		}else {
			System.out.println("로그인 실패");
			
			return "redirect:loginForm?result=fail";
		}
		
	}
	
	//로그아웃
	@RequestMapping(value= "logout", method= {RequestMethod.GET, RequestMethod.POST})
	public String logout(HttpSession session) {
		System.out.println(" UserCtrl > logout");
		
		//세션 삭제
		session.removeAttribute("authUser");
		
		return "redirect:/main";
	}
	
	//회원정보 수정 폼
	@RequestMapping(value= "modifyForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm(HttpSession session, Model model) {
		System.out.println(" UserCtrl > modifyForm");
		
		//세션에서 no 가져오기
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		int no = authUser.getNo();
		
		//no로 user정보 불러오기
		UserVo userVo = userService.getUser(no);
		
		//model을 사용해서 attribut 보내기
		model.addAttribute(userVo);
		System.out.println(userVo);
		
		return "user/modifyForm";
	}
	
	//회원정보 수정
	@RequestMapping(value= "modify", method= {RequestMethod.GET, RequestMethod.POST})
	public String modify(@ModelAttribute UserVo userVo) {
		System.out.println(" UserCtrl > modify");
		
		userService.update(userVo);
		
		return "redirect:/main";
	}
	
	

}
