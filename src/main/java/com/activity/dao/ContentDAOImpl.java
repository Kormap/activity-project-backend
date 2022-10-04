package com.activity.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.activity.domain.CategoryDTO;
import com.activity.domain.ContentCategoryBO;
import com.activity.domain.ContentDTO;
import com.activity.domain.ContentListBO;
import com.activity.domain.ImageDTO;
import com.activity.domain.OptionDTO;

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
	public ContentCategoryBO getContentInfo(int content_no) throws Exception {
		
		return sql.selectOne(NAMESPACE + ".getContentInfo",content_no);
	}

	//컨텐츠 타이틀 이미지 조회 
	public ImageDTO getTitleImage(int content_no) throws Exception { 
	
		return sql.selectOne(NAMESPACE + ".getTitleImage",content_no);
	}
	
	//컨텐츠 이미지 조회 (컨텐츠 - 이미지 테이블 조인 테스트용) 
	public List<ImageDTO> getContentImage(int content_no) throws Exception {
		return sql.selectList(NAMESPACE + ".getContentImage", content_no);
	}
	
	//컨텐츠 옵션 조회
	public List<OptionDTO> getContentOption(int content_no) throws Exception {
		
		return sql.selectList(NAMESPACE + ".getContentOption",content_no);
	}
	
	//컨텐츠 타이틀 이미지 리스트 
	public List<ContentListBO> getContentListBO() throws Exception { 
		
		return sql.selectList(NAMESPACE +".getContentListBO");
	}

	@Override
	public List<ContentListBO> searchContent(String searchText) {
		return sql.selectList(NAMESPACE + ".searchContent", searchText);
	}

	//전체 카테고리 조회 
	@Override
	public List<CategoryDTO> getCategory() {
		return sql.selectList(NAMESPACE +".getCategory");
	}

	//카테고리별 리스트 조회 
	@Override
	public List<ContentCategoryBO> getDetailCategoryList(int category_no) {
		return sql.selectList(NAMESPACE + ".getDetailCategoryList",category_no);
	}

}
