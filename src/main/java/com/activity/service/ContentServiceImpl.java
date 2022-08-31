package com.activity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activity.dao.ContentDAO;
import com.activity.domain.ContentDTO;
import com.activity.domain.ContentOptionBO;
import com.activity.domain.ContentOptionDTO;
import com.activity.domain.ImageDTO;

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
	public ContentDTO getContentInfo() throws Exception {
			
		return contentdao.getContentInfo();
	}

	//컨텐츠 타이틀 이미지 조회 
	public ImageDTO getTitleImage() throws Exception { 
	
		return contentdao.getTitleImage();
	}
	
	//컨텐츠 이미지 조회 (컨텐츠 - 이미지 테이블 조인) 
	public List<ImageDTO> getContentImage() throws Exception { 
		
		return contentdao.getContentImage();
	}
	
	//컨텐츠 옵션 조회
	public List<ContentOptionBO> getContentOption() throws Exception {  
		
		return contentdao.getContentOption();
	}


	
}
