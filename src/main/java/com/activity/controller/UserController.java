package com.activity.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
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
import org.springframework.web.bind.annotation.SessionAttributes;

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
	
	//로그인유저 정보조회 내정보관리페이지 
	@GetMapping("/myinfo")
	public List<UserDTO> getMyInfo(HttpSession session) throws Exception {
		session.getAttribute("user_email");
		String user_email = (String) session.getAttribute("user_email");
		List<UserDTO> getMyInfo = userService.getMyinfo(user_email);
		return getMyInfo;
	}
	
	
	//로그인 정보 체크 및 허용 (세션관리)
	@PostMapping("/login")
	public int getLoginCheck(@RequestBody HashMap<String, Object> requestJsonHashMap,
							  HttpSession session,UserDTO userdto) throws Exception { 
		
	    userdto.setUser_email(requestJsonHashMap.get("user_email").toString());
	    userdto.setUser_password(requestJsonHashMap.get("user_password").toString());

	    int checkLogin = userService.getLoginCheck(userdto);
	   
	    if(checkLogin==1) {
		   //로그인정보 세션 저장 Session
		   session.setAttribute("user_email", userdto.getUser_email());
		   //세션 유지시간 지정 ( 3600 초 = 60분 = 1시간 )
		   session.setMaxInactiveInterval(3600);
		   Object sessionID = session.getAttribute("user_email");
		   logger.info("sessionID= "+sessionID);
	    }
		return checkLogin;
	}
	
	
	//로그인 시 ID,PW 가져와서 콘솔에 확인 (Test 용)
	@PostMapping("/logintest")
	public ArrayList<HashMap<String,Object>> postInput(@RequestBody HashMap<String, Object> requestJsonHashMap)throws Exception {
		
		//response Data (여기서는 ArrayList 로 HashMap 을 감쌀 필요 까지는 없고, 
		//HashMap 타입으로 리턴도 가능-  확인:  52Line ArrayList 주석처리 후 return UserMap )
		ArrayList<HashMap<String, Object>> UserArray = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> UserMap = new LinkedHashMap<String, Object>();

		//HashMap 특성상 put 할 때 순서가 랜으로 출력됨
		//순서는 상관없지만, LinkedHashMap 으로 순서대로 출력되도록 확(임시)
		UserMap.put("user_email", requestJsonHashMap.get("user_email"));
		UserMap.put("user_password", requestJsonHashMap.get("user_password"));
		UserArray.add(UserMap);
		
		//테스트용 
		System.out.println(UserMap);
		System.out.println(UserArray);
	
		logger.info((String) requestJsonHashMap.get("user_email"));
		logger.info((String) requestJsonHashMap.get("user_password"));
		
		//Vue로 return 하여 콘솔에서 확인 할 수 있도록 설정해놓음(확인용, 임시)
		return UserArray;
	}
	
	//회원가입 시 , ID 중복 체크
	@PostMapping("/checkemail")
	public int getCheckID(@RequestBody HashMap<String, Object> requestJsonHashMap,UserDTO userdto) throws Exception{
		
	   logger.info("===아이디 중복 체크 진입===");
	   userdto.setUser_email(requestJsonHashMap.get("user_email").toString());
	   String test = userdto.getUser_email();
	   logger.info(test);
	   
		int checkID = userService.getCheckEmail(userdto);
		logger.info("checkID :{}", checkID);
		return checkID;
	}
	
	//회원가입 정보 insert
	@PostMapping("/signup")
	public UserDTO postSignup(@RequestBody HashMap<String, Object> requestJsonHashMap, 
			   				   HttpSession session, UserDTO userdto)throws Exception {
		
		
		
		//Vue 에서 받은 데이터 userDTO 로 넘기기 
		userdto.setUser_email(requestJsonHashMap.get("user_email").toString());
		userdto.setUser_name(requestJsonHashMap.get("user_name").toString());
		userdto.setUser_password(requestJsonHashMap.get("user_password").toString());
		userdto.setUser_tell(requestJsonHashMap.get("user_tell").toString());
		userdto.setCrtr_id((String) session.getAttribute("user_email"));
		
		System.out.println(userdto);
		userService.insertUser(userdto);
		
		//Vue로 return 하여 콘솔에서 확인 할 수 있도록 설정해놓음(확인용, 임시)
		return userdto;
	}
	
	//회원 정보 수정 update 
	@PostMapping("/update")
	public void postUpdate(@RequestBody HashMap<String, Object> requestJsonHashMap, UserDTO userdto) throws Exception{
		
		userdto.setUser_email(requestJsonHashMap.get("user_email").toString());
		userdto.setUser_tell(requestJsonHashMap.get("user_tell").toString());
		userService.updateUser(userdto);
		
	}
	
	//회원 로그아웃 세션 Session 삭제
	@GetMapping("/logout")
	public void getLogout(HttpSession session) { 
		
		//로그아웃 시 세션 삭제 
		session.invalidate();
		
	}
	
	
	//회원 정보 삭제 delete
	@PostMapping("/delete")
	public void postDelete(@RequestBody HashMap<String, Object> requestJsonHashMap, 
										HttpSession session, UserDTO userdto) throws Exception { 
		
		userdto.setUser_email(requestJsonHashMap.get("user_email").toString());
		userService.deleteUser(userdto);
		session.invalidate();
		
	}
	
	
	
	
	
	
		//====================   HashMap 으로 초반에 공부용도로 코딩 ,백업 후 삭제(임시) 
		//====================   Json 타입 데이터(Vue) -> HashMap -> ArrayList 
		//회원가입 정보 insert
		
		/*
	@PostMapping("/signup")
	public ArrayList<HashMap<String,Object>> postInput(@RequestBody HashMap<String, Object> requestJsonHashMap)throws Exception {
		
		response Data (여기서는 ArrayList 로 HashMap 을 감쌀 필요 까지는 없고, 
		//HashMap 타입으로 리턴도 가능-  확인:  52Line ArrayList 주석처리 후 return UserMap )
		ArrayList<HashMap<String, Object>> signupArray = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> signupMap = new LinkedHashMap<String, Object>();

		//HashMap 특성상 put 할 때 순서가 랜으로 출력됨
		//여기서는 순서는 상관없지만, LinkedHashMap 으로 순서대로 출력되도록 구현(임시)
		signupMap.put("user_email", requestJsonHashMap.get("user_email"));
		signupMap.put("user_name", requestJsonHashMap.get("user_name"));
		signupMap.put("user_password", requestJsonHashMap.get("user_password"));
		signupMap.put("user_tell", requestJsonHashMap.get("user_tell"));
		//HashMap ArrayList에 넣기
		signupArray.add(signupMap);
		
		//테스트용 
		System.out.println(signupMap);
		System.out.println(signupArray);
		logger.info((String) requestJsonHashMap.get("user_email"));
		logger.info((String) requestJsonHashMap.get("user_password"));
		logger.info((String) requestJsonHashMap.get("user_name"));
		logger.info((String) requestJsonHashMap.get("user_tell"));
		//Vue로 return 하여 콘솔에서 확인 할 수 있도록 설정해놓음(확인용, 임시)
		return signupArray;
	} 
	*/
		
	
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
