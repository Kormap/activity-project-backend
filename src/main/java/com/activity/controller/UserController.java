package com.activity.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.activity.domain.UserDTO;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.activity.domain.UserDTO;
import com.activity.service.UserService;

@Controller
@RestController
@RequestMapping("/api/user/*")
public class UserController {

	@Autowired
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	
	//유저 정보 리스트 조회 (테스트용)
	@GetMapping("/list")
	public List<UserDTO> getUserList() throws Exception {
		List<UserDTO> getUserList = userService.getUserList();
		return getUserList;
	}
	
	//로그인 시 ID,PW 가져오기 
	
	@PostMapping("/login")
	public ArrayList<HashMap<String,Object>> postInput(@RequestBody HashMap<String, Object> requestJsonHashMap)throws Exception {
		
		//response Data (여기서는 ArrayList 로 HashMap 을 감쌀 필요 까지는 없고, 
		//HashMap 타입으로 리턴도 가능-  확인:  52Line ArrayList 주석처리 후 return UserMap )
		ArrayList<HashMap<String, Object>> UserArray = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> UserMap = new LinkedHashMap<String, Object>();

		//HashMap 특성상 put 할 때 순서가 랜으로 출력됨
		//여기서는 순서는 상관없지만, LinkedHashMap 으로 순서대로 출력되도록 구현(임시)
		UserMap.put("user_id", requestJsonHashMap.get("user_id"));
		UserMap.put("user_password", requestJsonHashMap.get("user_password"));
		UserArray.add(UserMap);
		
		//테스트용 
		System.out.println(UserMap);
		System.out.println(UserArray);
	
		logger.info((String) requestJsonHashMap.get("user_id"));
		logger.info((String) requestJsonHashMap.get("user_password"));
		
		//Vue로 return 하여 콘솔에서 확인 할 수 있도록 설정해놓음(확인용, 임시)
		return UserArray;
	}
	
	//로그인 시 ID,PW 가져오기(String type 테스트용)
//	@PostMapping("login1")
//	public String postInput1(@RequestBody String user_info) throws Exception { 
//		
//		
//		return user_info;
//		
//	}

	
//	private List<UserDTO> UserDTOs;
//
//	public UserController() {
//		UserDTOs = new ArrayList<>();
//		UserDTOs.add(new UserDTO("test@email", "1234", "홍길동", "1996-10-08", "010-1234-5678"));
//	}
//
//	//url 에 특정 email 값이 들어 왔을 때 DataDTOs 함수를 반환.
//	@GetMapping("/")
//	public List<UserDTO> list() {
//		return UserDTOs;
//	}
//
//	@GetMapping("/{user_email}")
//	public UserDTO get(@PathVariable String user_email){ 
//		return UserDTOs.stream().filter(f->user_email.equals(f.getUser_email())).findAny().orElse(null);
//		}
//	
//	//Data 를 Vue.js 서버에 전송 
//	@PostMapping("/post")
//	public String PostTest(@RequestBody String msg) {
//		return "post success!"+msg ;
//	}

}
