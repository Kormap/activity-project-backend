package com.activity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activity.dao.ContentDAO;
import com.activity.domain.CategoryDTO;
import com.activity.domain.ContentCategoryBO;
import com.activity.domain.ContentDTO;
import com.activity.domain.ContentListBO;
import com.activity.domain.ImageDTO;
import com.activity.domain.OptionDTO;

@Service
public class ContentServiceImpl implements ContentService {
	
	@Autowired
	private ContentDAO contentdao;
	
	//컨텐츠 리스트 조회(테스트용,임시)
	@Override
	public List<ContentDTO> getContentList() throws Exception {
		
		return contentdao.getContentList();
	}

	//컨텐츠 한행 조회
	@Override
	public ContentCategoryBO getContentInfo(int content_no) throws Exception {
			
		return contentdao.getContentInfo(content_no);
	}

	//컨텐츠 타이틀 이미지 조회 
	public ImageDTO getTitleImage(int content_no) throws Exception { 
				
		return contentdao.getTitleImage(content_no);
	}
	
	//컨텐츠 이미지 조회 (컨텐츠 - 이미지 테이블 조인) 
	public List<ImageDTO> getContentImage(int content_no) throws Exception { 
//		System.out.println("Service content_no= "+content_no);
		return contentdao.getContentImage(content_no);
	}
	
	//컨텐츠 옵션 조회
	public List<OptionDTO> getContentOption(int content_no) throws Exception {  
		
		return contentdao.getContentOption(content_no);
	}

	//컨텐츠 타이틀 이미지 리스트 
	public List<ContentListBO> getContentListBO() throws Exception { 
		
		return contentdao.getContentListBO();
	}

	@Override
	public List<ContentListBO> searchContent(String searchText) {
		
		return contentdao.searchContent(searchText);
	}

	//카테고리 조회 
	@Override
	public List<CategoryDTO> getCategory() throws Exception {

		return contentdao.getCategory();
	}

	@Override
	public List<ContentCategoryBO> getDetailCategoryList(int category_no) {
		return contentdao.getDetailCategoryList(category_no);
	}
	
}
