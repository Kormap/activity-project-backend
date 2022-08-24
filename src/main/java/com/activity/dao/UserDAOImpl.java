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
	
	@Override
	public List<UserDTO> getUserList() throws Exception {
		return sql.selectList(NAMESPACE + ".getUserList");
	}

}
