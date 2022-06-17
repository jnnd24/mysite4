package com.javaex.controller;

import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	//메소드gs
	
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
	public String login(@ModelAttribute UserVo userVo) {
		System.out.println(" UserCtrl > login");
		
		UserVo authUser = userService.getUser(userVo);
		
		System.out.println(authUser.toString());
		
		//로그인정보만 담으면 끝
		
		return "";
		
	}
	
	
	
	

}
