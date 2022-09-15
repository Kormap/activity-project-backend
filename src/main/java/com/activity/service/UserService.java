package com.activity.service;

import java.util.List;
import com.activity.domain.UserDTO;

public interface UserService {
	
	//유저 정보 리스트 
	public List<UserDTO> getUserList() throws Exception;
	
	//로그인 유저 정보 조회 
	public List<UserDTO> getMyinfo(String user_email) throws Exception;
	
	//회원가입 정보 insert
	public void insertUser(UserDTO userdto) throws Exception;
	
	//ID 중복 체크 
	public int getCheckEmail(UserDTO userdto) throws Exception;
	
	//로그인 체크 
	public int getLoginCheck(UserDTO userdto) throws Exception;

	//유저 정보 업데이트 
	public void updateUser(UserDTO userdto);

	//유저 정보 삭제 
	public void deleteUser(UserDTO userdto);
	
}
 

