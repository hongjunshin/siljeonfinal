package com.my.app.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping(value="/login")
public class LoginController{
	
	
	
	@Autowired
	UserService service;
	

	
	@RequestMapping(value="/login",method = {RequestMethod.POST, RequestMethod.GET})
	public String login(String t, Model model) {
		return "login";
	}
	
	@RequestMapping(value="/loginOK",method=RequestMethod.POST)
	public String loginCheck(HttpSession session,UserVO vo, Model model) {
		
		String username = service.getname("userid");
		model.addAttribute("un",username);
		
		String returnURL="";
		if(session.getAttribute("login")!=null) {
			session.removeAttribute("login");
		}
		UserVO loginvo=service.getUser(vo);
		
		if(loginvo!=null) {
			
			System.out.println("asd");
			System.out.println("로그인 성공!");
			session.setAttribute("login", loginvo);
			
			returnURL = "redirect:/list";
		}else {
			System.out.println("로그인 실패!");
			returnURL = "redirect:/login/login";
		}
		return returnURL;
	}
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login/login";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup(){
		return "signup";
	}
	
	@RequestMapping(value="/signupOk", method=RequestMethod.POST)
	public String signupOk(UserVO vo) {
		service.insertUser(vo);
		return "redirect:/login/login";
	}

	
}
















