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

	
	
	
	
}
