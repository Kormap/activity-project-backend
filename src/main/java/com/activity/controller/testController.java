//package com.activity.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//import com.activity.domain.UserDTO;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/user")
//public class testController {
//	private List<UserDTO> UserDTOs;
//
//	public testController() {
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
//}
//
//
//
