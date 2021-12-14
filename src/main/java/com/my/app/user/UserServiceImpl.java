package com.my.app.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.app.board.BoardVO;
import com.my.app.user.UserVO;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDAO userDAO;
	
	@Override
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}
	
	@Override
	public int insertUser(UserVO vo) {
		return userDAO.insertUser(vo);
	}
	
	@Override
	public int deleteUser(UserVO vo) {
		return userDAO.deleteUser(vo);
	}
	
	@Override
	public UserVO getUserName(int seq) {
		return userDAO.getUserName(seq);
	}

	@Override
	public List<UserVO> getUserList(){
		List<UserVO> result = userDAO.getUserList();
		return result;
	}
	
	@Override
	public String getname(String temp) {
		return userDAO.getname(temp);
	}
}

