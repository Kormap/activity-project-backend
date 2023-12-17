package com.activity.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.activity.domain.CategoryDTO;
import com.activity.domain.ContentCategoryBO;
import com.activity.domain.ContentDTO;
import com.activity.domain.ContentListBO;
import com.activity.domain.ImageDTO;
import com.activity.domain.OptionDTO;
import com.activity.service.ContentService;

import com.activity.controller.UserController;

@Controller
@RestController
@RequestMapping("/api/content/*")
public class ContentController {
	
	@Autowired
	private ContentService contentService;
	
	private static final Logger logger = LoggerFactory.getLogger(ContentController.class);

	private static final String prefixApiUrl = "/api/content/";

	//컨텐츠 한 건 조회 (디테일페이지에서 사용) 
	@PostMapping("/info")
	public ContentCategoryBO getContentInfo(@RequestBody HashMap<String, Object> requestJsonHashMap) throws Exception { 
		
		String queryno = (String) requestJsonHashMap.get("Query_content_no"); //
		int content_no = Integer.parseInt(queryno);
		ContentCategoryBO getContentInfo = contentService.getContentInfo(content_no);
		return getContentInfo;
	}
	
	
	//========================================================================
	
	@GetMapping("/list")
	//컨텐츠 리스트 조회(테스트용,임시)
	public List<ContentDTO> getContentList() throws Exception { 
		
		List<ContentDTO> getContentList = contentService.getContentList();
		logger.info("컨텐츠리스트 조회");
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
		List<ImageDTO> getContentImage = contentService.getContentImage(content_no);
		logger.info(getContentImage.toString());
		return getContentImage;
	}

	
	//컨텐츠 옵션 조회
	@PostMapping("/option")
	public List<OptionDTO> getContentOption(@RequestBody HashMap<String, Object> requestJsonHashMap) throws Exception { 
		
		String queryno = (String) requestJsonHashMap.get("Query_content_no");
		int content_no = Integer.parseInt(queryno);
		List<OptionDTO> getContentOption = contentService.getContentOption(content_no);
		return getContentOption;
	}

	// ======================================================================================
	
	//메인페이지 (바디컴포넌트 등) 
	//필요 데이터 : 컨텐츠리스트, 컨텐츠 타이틀이미지, 컨텐츠 카테고리
	@GetMapping("/mainlist")
	public List<ContentListBO> getContentListBO(HttpServletRequest request) throws Exception {
		logger.info("메인페이지 조회 : " + prefixApiUrl + "getContentListBO");

		List<ContentListBO> getContentListBO = contentService.getContentListBO();
		if(request.getCookies()==null) {
			logger.info("쿠키가 존재하지 않습니다");
		}

		return getContentListBO;
	}
	
	//메인페이지 -> 상세페이지로 넘어갈때 Vue 에서 Content_no , Query 받기 (테스트용) 
	@PostMapping("/queryno")
	public void postQueryno(@RequestBody HashMap<String, Object> requestJsonHashMap)throws Exception {
		//Object 타입을 스트링 타입으로 => 스트링타입을 Integer.parseInt 로 형변환 
		String queryno = (String) requestJsonHashMap.get("Query_content_no");
		int content_no = Integer.parseInt(queryno);
	}
	
	//컨텐츠 검색 API
	@PostMapping("search")
	public List<ContentListBO> postsearchText(@RequestBody HashMap<String, Object> requestJsonHashMap) throws Exception{
		String searchText = (String) requestJsonHashMap.get("searchText"); 
		List<ContentListBO> searchContent = contentService.searchContent(searchText);
		return searchContent;
	}
	
	//전체 카테고리 조회
	@GetMapping("category")
	public List<CategoryDTO> getCategory() throws Exception{
		List<CategoryDTO> getCategory = contentService.getCategory();
		return getCategory; 
	}
	
	//쿼리에 담긴 카테고리별 조회
	@PostMapping("detailcategory")
	public List<ContentCategoryBO> getDetailCategoryList(@RequestBody HashMap<String, Object> requestJsonHashMap)throws Exception {
//		requestJsonHashMap.get("searchText");
		int category_no =Integer.parseInt(requestJsonHashMap.get("category_no").toString());
		List<ContentCategoryBO> getDetailCategoryList = contentService.getDetailCategoryList(category_no);
		return getDetailCategoryList;
	}
	
}
