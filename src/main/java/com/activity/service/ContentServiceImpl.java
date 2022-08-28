package com.activity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activity.dao.ContentDAO;
import com.activity.domain.ContentDTO;

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

}
