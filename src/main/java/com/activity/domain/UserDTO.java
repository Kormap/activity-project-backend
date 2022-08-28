package com.activity.domain;
/*import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;*/
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
	
	private String user_email;
	private String user_password;
	private String user_name;
	private String user_tell;
//	private Void getUser_email;
//	private Void getUser_name;
//	private Void setUser_id;
//	private Void setUser_name;
	
	//생성자 
	public UserDTO(String user_email, String user_password, String user_name, String user_tell) {
		super();
		this.user_email = user_email;
		this.user_password = user_password;
		this.user_name = user_name;
		this.user_tell = user_tell;
	}

	@Override
	public String toString() {
		return "UserDTO [user_email=" + user_email + ", user_password=" + user_password + ", user_name=" + user_name
				+ ", user_tell=" + user_tell + "]";
	}



}