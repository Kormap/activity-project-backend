package com.activity.service;

import java.util.List;

import com.activity.domain.ContentDTO;

public interface ContentService {

	//컨텐츠 리스트 조회(테스트용,임시)
	public List<ContentDTO> getContentList() throws Exception;
	
	//컨텐츠 한행 조회
	public ContentDTO getContentInfo() throws Exception;
	
}
