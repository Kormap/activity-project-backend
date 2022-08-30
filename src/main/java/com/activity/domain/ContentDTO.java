package com.activity.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContentDTO {

	//Content 테이블 
	private int content_no;
	private String content_name;
	private String content_info;
	private int content_price;
	private int content_capacity;
	private String content_yn;
	private String admin_email;

	
	//Content_Option 테이블 넣을지.. DTO 를 만들지..
	
	
	//생성자 
	public ContentDTO(int content_no, String content_name, String content_info, int content_price, int content_capacity,
			String content_yn, String admin_email) {
		super();
		this.content_no = content_no;
		this.content_name = content_name;
		this.content_info = content_info;
		this.content_price = content_price;
		this.content_capacity = content_capacity;
		this.content_yn = content_yn;
		this.admin_email = admin_email;
	}


	@Override
	public String toString() {
		return "ContentDTO [content_no=" + content_no + ", content_name=" + content_name + ", content_info="
				+ content_info + ", content_price=" + content_price + ", content_capacity=" + content_capacity
				+ ", content_yn=" + content_yn + ", admin_email=" + admin_email + "]";
	}	
	
	
	
	
}
