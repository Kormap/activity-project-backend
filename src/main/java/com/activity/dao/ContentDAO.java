package com.activity.dao;

import java.util.List;

import com.activity.domain.CategoryDTO;
import com.activity.domain.ContentCategoryBO;
import com.activity.domain.ContentDTO;
import com.activity.domain.ContentListBO;
import com.activity.domain.ImageDTO;
import com.activity.domain.OptionDTO;

public interface ContentDAO {
	
	//컨텐츠 리스트 조회(테스트용,임시)
	public List<ContentDTO> getContentList() throws Exception;
	
	//컨텐츠 한행 조회
	public ContentCategoryBO getContentInfo(int content_no) throws Exception;
	
	//컨텐츠 타이틀 이미지 조회 
	public ImageDTO getTitleImage(int content_no) throws Exception;
	
	//컨텐츠 이미지 조회 (컨텐츠 - 이미지 테이블 조인) 
	public List<ImageDTO> getContentImage(int content_no) throws Exception;
	
	//컨텐츠 옵션 조회
	public List<OptionDTO> getContentOption(int content_no) throws Exception;
	
	//메인페이지 - 컨텐츠테이블 , 타이틀이미지 리스트 조회
	public List<ContentListBO> getContentListBO() throws Exception;

	//컨텐츠 검색 기능 
	public List<ContentListBO> searchContent(String searchText);

	//카테고리 조회 기능 
	public List<CategoryDTO> getCategory();

	//카테고리별 리스트 조회 
	public List<ContentCategoryBO> getDetailCategoryList(int category_no);
}
