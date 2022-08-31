package com.activity.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.activity.domain.ContentDTO;
import com.activity.domain.ContentOptionBO;
import com.activity.domain.ContentOptionDTO;
import com.activity.domain.ImageDTO;

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

	//컨텐츠 타이틀 이미지 조회 
	public ImageDTO getTitleImage() throws Exception { 
	
		return sql.selectOne(NAMESPACE + ".getTitleImage");
	}
	
	//컨텐츠 이미지 조회 (컨텐츠 - 이미지 테이블 조인 테스트용) 
	public List<ImageDTO> getContentImage() throws Exception {
		
		return sql.selectList(NAMESPACE + ".getContentImage");
	}
	
	//컨텐츠 옵션 조회
	public List<ContentOptionBO> getContentOption() throws Exception {
		
		return sql.selectList(NAMESPACE + ".getContentOption");
	}

}
