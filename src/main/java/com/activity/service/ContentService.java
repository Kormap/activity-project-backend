package com.activity.service;

import java.util.List;

import com.activity.domain.ContentDTO;
import com.activity.domain.ImageDTO;

public interface ContentService {

	//컨텐츠 리스트 조회(테스트용,임시)
	public List<ContentDTO> getContentList() throws Exception;
	
	//컨텐츠 한행 조회
	public ContentDTO getContentInfo() throws Exception;

	//컨텐츠 이미지 조회 (컨텐츠 - 이미지 테이블 조인) 
	public List<ImageDTO> getContentImage() throws Exception;

	//컨텐츠 타이틀 이미지 조회 
	public ImageDTO getTitleImage() throws Exception;
	
}
