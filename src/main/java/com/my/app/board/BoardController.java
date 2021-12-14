package com.my.app.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.my.app.user.UserService;
import com.my.app.user.UserVO;


@Controller
public class BoardController{
	
	
	
	@Autowired
	BoardService boardService;
	UserService userService;
	
	
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String boardlist(Model model, UserVO vo) {
		model.addAttribute("list",boardService.getBoardList());
		return "list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addPost() {
		return "addpostform";
	}
	
	@RequestMapping(value="/addok",method = RequestMethod.POST)
	public String addPostOK(BoardVO vo) {
		boardService.insertBoard(vo);
		return "redirect:list";
	}
	
	@RequestMapping(value="/editform/{id}",method= {RequestMethod.GET, RequestMethod.POST})
	public String editPost(@PathVariable("id")int id, Model model) {
		BoardVO boardVO=boardService.getBoard(id);
		model.addAttribute("boardVO",boardVO);
		return "editform";
	}
	
	@RequestMapping(value="/editok",method=RequestMethod.POST)
	public String editPostOK(BoardVO vo) {
		if(boardService.updateBoard(vo)==0) {
			System.out.println("수정 성공");
		}
		else System.out.println("수정 실패");
		
		return "redirect:list";
	}
	
	@RequestMapping(value="/deleteok/{id}",method=RequestMethod.GET)
	public String deletePostOK(@PathVariable("id")int id) {
		if(boardService.deleteBoard(id)==0)
			System.out.println("삭제 성공");
		else
			System.out.println("삭제 실패");
		
		return "redirect:../list";
	}
	
}