package com.activity.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.activity.domain.ContentDTO;
import com.activity.domain.ContentListBO;
import com.activity.domain.ContentOptionBO;
import com.activity.domain.ContentOptionDTO;
import com.activity.domain.ImageDTO;
import com.activity.service.ContentService;

@Controller
@RestController
@RequestMapping("/api/content/*")
public class ContentController {
	
	@Autowired
	private ContentService contentService;
	
	private static final Logger logger = LoggerFactory.getLogger(ContentController.class);

	//컨텐츠 한 건 조회
	@PostMapping("/info")
	public ContentDTO getContentInfo(@RequestBody HashMap<String, Object> requestJsonHashMap) throws Exception { 
		
		String queryno = (String) requestJsonHashMap.get("Query_content_no");
		int content_no = Integer.parseInt(queryno);
		ContentDTO getContentInfo = contentService.getContentInfo(content_no);
		return getContentInfo;
	}
	
	
	//========================================================================
	
	@GetMapping("/list")
	//컨텐츠 리스트 조회(테스트용,임시)
	public List<ContentDTO> getContentList() throws Exception { 
		
		List<ContentDTO> getContentList = contentService.getContentList();
		logger.info("컨텐츠리스트 조회");
		System.out.println(getContentList);
		return getContentList;
	}
	
	@PostMapping("/titleimage")
	public String getTitleImage(@RequestBody HashMap<String, Object> requestJsonHashMap) throws Exception {
		
		String queryno = (String) requestJsonHashMap.get("Query_content_no");
		int content_no = Integer.parseInt(queryno);
		String gettitleImage =  contentService.getTitleImage(content_no).getImage_path();
		logger.info("gettitleImage= "+gettitleImage);
		return gettitleImage;
	}
	
	
	@PostMapping("/image")
	//컨텐츠 이미지 조회 (컨텐츠 - 이미지 테이블 조인) 
	public List<ImageDTO> getContentImage(@RequestBody HashMap<String, Object> requestJsonHashMap) throws Exception { 
		
		String queryno = (String) requestJsonHashMap.get("Query_content_no");
		int content_no = Integer.parseInt(queryno);
//		System.out.println("content_no= " +content_no);
		List<ImageDTO> getContentImage = contentService.getContentImage(content_no);
		logger.info(getContentImage.toString());
		return getContentImage;
	}

	
	//컨텐츠 옵션 조회
	@PostMapping("/option")
	public List<ContentOptionBO> getContentOption(@RequestBody HashMap<String, Object> requestJsonHashMap) throws Exception { 
		
		String queryno = (String) requestJsonHashMap.get("Query_content_no");
		int content_no = Integer.parseInt(queryno);
		System.out.println("OptionAPI content_no= " +content_no);
		List<ContentOptionBO> getContentOption = contentService.getContentOption(content_no);
		
		
//		String content_no = getContentOption().
//		logger.info("content_no = "+content_no);
		System.out.println(getContentOption);
		return getContentOption;
	}

	// ======================================================================================
	
	//메인페이지 (바디컴포넌트 등) 
	//필요 데이터 : 컨텐츠리스트, 컨텐츠 타이틀이미지, 컨텐츠 카테고리
	@GetMapping("/mainlist")
	public List<ContentListBO> getContentListBO() throws Exception {
		
		
		List<ContentListBO> getContentListBO = contentService.getContentListBO();
		
		return getContentListBO;
	}
	
	//메인페이지 -> 상세페이지로 넘어갈때 Vue 에서 Content_no , Query 받기 
	@PostMapping("/queryno")
	public void postQueryno(@RequestBody HashMap<String, Object> requestJsonHashMap )throws Exception {
		//Object 타입을 스트링 타입으로 => 스트링타입을 Integer.parseInt 로 형변환 
		String queryno = (String) requestJsonHashMap.get("Query_content_no");
		int content_no = Integer.parseInt(queryno);
//		System.out.println("content_no= " +content_no);
//		contentdto.setContent_no(content_no);
//		imagedto.setContent_no(content_no);
		
//		contentService.getContentImage();
//		logger.info("getContent_no={}",contentdto.getContent_no());
	}
	
}
