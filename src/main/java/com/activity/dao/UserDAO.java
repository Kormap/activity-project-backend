package com.activity.dao;

import java.util.List;

import com.activity.domain.UserDTO;

public interface UserDAO {

	//유저 정보 리스트 
	public List<UserDTO> getUserList() throws Exception;
	
}
