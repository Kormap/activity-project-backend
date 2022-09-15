package com.activity.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.activity.domain.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO{

	@Autowired
	private SqlSession sql;
	private static final String NAMESPACE = "com.activity.mybatis-mappers.UserMapper";
	
	//유저 정보 리스트 
	@Override
	public List<UserDTO> getUserList() throws Exception {
		return sql.selectList(NAMESPACE + ".getUserList");
	}
	
	//로그인 유저 정보 조회 
	public List<UserDTO> getMyinfo(String user_email) throws Exception {
		return sql.selectList(NAMESPACE + ".getMyInfo", user_email);
	}

	//회원가입 정보 insert
	@Override
	public void insertUser(UserDTO userdto) throws Exception {
		
		sql.insert(NAMESPACE + ".insertUser", userdto);
	
	}
	
	//ID 중복 체크 
	@Override
	public int getCheckEmail(UserDTO userdto) throws Exception {
		
		return sql.selectOne(NAMESPACE + ".getCheckEmail",userdto);
	}

	//로그인 체크 
	public int getLoginCheck(UserDTO userdto) throws Exception {
		
		return sql.selectOne(NAMESPACE + ".getLoginCheck", userdto);
	}

	@Override
	public void updateUser(UserDTO userdto) {
		sql.update(NAMESPACE + ".updateUser", userdto);
		
	}

	@Override
	public void deleteUser(UserDTO userdto) {
		sql.delete(NAMESPACE + ".deleteUser", userdto);
	}
	
	
	
}
