package com.activity.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.activity.domain.ContentDTO;
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
	@GetMapping("/info")
	public ContentDTO getContentInfo() throws Exception { 
		
		ContentDTO getContentInfo = contentService.getContentInfo();
		return getContentInfo;
	}
	
	@GetMapping("/list")
	//컨텐츠 리스트 조회(테스트용,임시)
	public List<ContentDTO> getContentList() throws Exception { 
		
		List<ContentDTO> getContentList = contentService.getContentList();
		logger.info("컨텐츠리스트 조회");
		System.out.println(getContentList);
		return getContentList;
	}
	
	@GetMapping("/titleimage")
	public String gettitleImage() throws Exception {
		
		String gettitleImage =  contentService.getTitleImage().getImage_path();
		logger.info("gettitleImage= "+gettitleImage);
		return gettitleImage;
	}
	
	
	@GetMapping("/image")
	//컨텐츠 이미지 조회 (컨텐츠 - 이미지 테이블 조인) 
	public List<ImageDTO> getContentImage() throws Exception { 
		
		List<ImageDTO> getContentImage = contentService.getContentImage();
		logger.info(getContentImage.toString());
		return getContentImage;
	}

	
	//컨텐츠 옵션 조회
	@GetMapping("/option")
	public List<ContentOptionBO> getContentOption() throws Exception { 
		
		List<ContentOptionBO> getContentOption = contentService.getContentOption();
		
		
//		String content_no = getContentOption().
//		logger.info("content_no = "+content_no);
		System.out.println(getContentOption);
		return getContentOption;
	}

	

}
