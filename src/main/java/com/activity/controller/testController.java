package com.activity.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.activity.domain.UserDTO;

@RestController
@RequestMapping("/api/user")
public class testController {
	private List<UserDTO> UserDTOs;

	public testController() {
//		UserDTOs = new ArrayList<>();
//		UserDTOs.add(new UserDTO("test@email", "1234", "홍길동", "1996-10-08", "010-1234-5678"));
	}

	// url 에 특정 email 값이 들어 왔을 때 DataDTOs 함수를 반환.
	@GetMapping("/")
	public List<UserDTO> list() {
		return UserDTOs;
	}

	@GetMapping("/{user_email}")
	public UserDTO get(@PathVariable String user_email) {
		return UserDTOs.stream().filter(f -> user_email.equals(f.getUser_email())).findAny().orElse(null);
	}

	// Data 를 Vue.js 서버에 전송
	@PostMapping("/post")
	public String PostTest(@RequestBody String msg) {
		return "post success!" + msg;
	}
	
	// Data 를 Vue.js 서버에 전송
		@PostMapping(value = "/image" ,consumes={MediaType.MULTIPART_FORM_DATA_VALUE})
		public String imageTest(@RequestPart(value = "image_path", required = false) MultipartFile file) {
			System.out.println(file.getOriginalFilename());
			String fileRealName = file.getOriginalFilename(); //파일명을 얻어낼 수 있는 메서드!
			long size = file.getSize(); //파일 사이즈
			
			System.out.println("파일명 : "  + fileRealName);
			System.out.println("용량크기(byte) : " + size);
			
			//서버에 저장할 파일이름 fileextension으로 .jsp이런식의  확장자 명을 구함
			String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."),fileRealName.length());
			String uploadFolder = "/Users/donghyeok/workspace/vue-workspace/vue-activity-project/public";
			
			
			/*
			  파일 업로드시 파일명이 동일한 파일이 이미 존재할 수도 있고 사용자가 
			  업로드 하는 파일명이 언어 이외의 언어로 되어있을 수 있습니다. 
			  타인어를 지원하지 않는 환경에서는 정산 동작이 되지 않습니다.(리눅스가 대표적인 예시)
			  고유한 랜던 문자를 통해 db와 서버에 저장할 파일명을 새롭게 만들어 준다.
			 */
			
			UUID uuid = UUID.randomUUID();
			System.out.println(uuid.toString());
			String[] uuids = uuid.toString().split("-");
			
			String uniqueName = uuids[0];
			System.out.println("생성된 고유문자열 " + uniqueName);
			System.out.println("확장자명 " + fileExtension);
			
			
			
			// File saveFile = new File(uploadFolder+"\\"+fileRealName); uuid 적용 전
			
			File saveFile = new File(uploadFolder+"/"+uniqueName + fileExtension);  // 적용 후
			try {
				file.transferTo(saveFile); // 실제 파일 저장메서드(filewriter 작업을 손쉽게 한방에 처리해준다.)
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return  "./" +uniqueName + fileExtension;
			//return  "http://localhost:8080/Users/donghyeok/Pictures/" + file.getOriginalFilename();
		}
}
