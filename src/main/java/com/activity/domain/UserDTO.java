package com.activity.domain;
import java.sql.Date;

import lombok.AllArgsConstructor;
/*import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;*/
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class UserDTO {
	
	private String user_email;
	private String user_password;
	private String user_name;
	private String user_tell;
	private String crtr_id;
	private Date crt_dttm; // datetime , current_timestamp
	private String updr_id;
	private Date upd_dttm;  // datetime , current_timestamp
	
	
	
	
//	USER_EMAIL,
//	USER_PASSWORD,
//	USER_NAME,
//	USER_TELL,
//	CRTR_ID ,
//	CRT_DTTM ,
//	UPDR_ID ,
//	UPD_DTTM 

	
//	//생성자 
//	public UserDTO(String user_email, String user_password, String user_name, String user_tell) {
//		super();
//		this.user_email = user_email;
//		this.user_password = user_password;
//		this.user_name = user_name;
//		this.user_tell = user_tell;
//	}
//
//	@Override
//	public String toString() {
//		return "UserDTO [user_email=" + user_email + ", user_password=" + user_password + ", user_name=" + user_name
//				+ ", user_tell=" + user_tell + "]";
//	}
//


}