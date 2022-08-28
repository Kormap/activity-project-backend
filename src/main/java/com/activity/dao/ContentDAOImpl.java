package com.activity.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.activity.domain.ContentDTO;

@Repository
public class ContentDAOImpl implements ContentDAO {
	
	@Autowired
	private SqlSession sql;
	private static final String NAMESPACE = "com.activity.mybatis-mappers.ContentMapper";
	
	@Override
	//컨텐츠 리스트 조회(테스트용,임시)
	public List<ContentDTO> getContentList() throws Exception{ 
		
		return sql.selectList(NAMESPACE + ".getContentList");
	}

	//컨텐츠 한행 조회
	@Override
	public ContentDTO getContentInfo() throws Exception {
		
		return sql.selectOne(NAMESPACE + ".getContentInfo");
	}


}
