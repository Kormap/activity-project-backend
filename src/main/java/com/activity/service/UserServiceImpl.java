package com.activity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activity.dao.UserDAO;
import com.activity.domain.UserDTO;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	//유저 정보 리스트 
	@Override
	public List<UserDTO> getUserList() throws Exception {
		return userDAO.getUserList();
		
	}
	
	//로그인 유저 정보 조회 
	public List<UserDTO> getMyinfo(String user_email) throws Exception {
		return userDAO.getMyinfo(user_email);
	}
	
	//회원가입 정보 insert
	@Override
	public void insertUser(UserDTO userdto) throws Exception {
		userDAO.insertUser(userdto);
		
	}
	
	//ID 중복 체크 
	@Override
	public int getCheckEmail(UserDTO userdto) throws Exception {
		return userDAO.getCheckEmail(userdto);
	}

	//로그인 체크 
	public int getLoginCheck(UserDTO userdto) throws Exception {
		return userDAO.getLoginCheck(userdto);
	}

	//유저 정보 업데이트 
	@Override
	public void updateUser(UserDTO userdto) {
		userDAO.updateUser(userdto);
	}

	@Override
	public void deleteUser(UserDTO userdto) {
		userDAO.deleteUser(userdto);
	}
	
	
}
