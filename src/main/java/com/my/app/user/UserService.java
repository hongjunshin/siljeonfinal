package com.my.app.user;

import java.util.List;

public interface UserService{
	public int insertUser(UserVO vo);
	public int deleteUser(UserVO vo);
	public UserVO getUser(UserVO vo);
	public UserVO getUserName(int seq);
	public List<UserVO> getUserList();
	
	public String getname(String temp);
}