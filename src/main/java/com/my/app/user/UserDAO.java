package com.my.app.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.app.board.BoardVO;

@Repository
public class UserDAO{
	@Autowired
	SqlSession sqlSession;
	public UserVO getUser(UserVO vo) {
		return sqlSession.selectOne("User.getUser",vo);
	}
	
	
	public int insertUser(UserVO vo) {
		int result= sqlSession.insert("User.insertUser",vo);
		return result;
	}
	
	public int deleteUser(UserVO vo) {
		int result = sqlSession.delete("User.deleteUser",vo);
		return result;
	}
	
	public UserVO getUserName(int seq) {
		return sqlSession.selectOne("User.getUserName",seq);
	}
	
	public List<UserVO> getUserList() {
		List<UserVO> result = sqlSession.selectList("User.getUserList");
		return result;
	}
	
	public String getname(String temp) {
		return sqlSession.selectOne("User.getname",temp);
	}
	
	
}


