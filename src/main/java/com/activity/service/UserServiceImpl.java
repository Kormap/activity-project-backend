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
	@Override
	public List<UserDTO> getUserList() throws Exception {
		return userDAO.getUserList();
	}
	
//	@Autowired
//	private UserMapper userMapper;

//	//유저 정보 리스트 
//	@Override
//	public List<UserDTO> getUserList() throws Exception {
//		return userMapper.getUserList();
//	}

}
