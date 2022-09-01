package com.activity.domain;

import lombok.Getter;
import lombok.Setter;


//메인페이지에 사용할 컨텐츠리스트와 타이틀이미지 비즈니스 오브젝트 

@Getter
@Setter
public class ContentListBO {

	//Content 테이블 
	private int content_no;
	private String content_name;
	private String content_info;
	private int content_price;
	private int content_capacity;
	private String content_yn;
	private String admin_email;
	
	//Image 테이블 
	private String image_path;

	
	
	public ContentListBO(int content_no, String content_name, String content_info, int content_price,
			int content_capacity, String content_yn, String admin_email, String image_path) {
		super();
		this.content_no = content_no;
		this.content_name = content_name;
		this.content_info = content_info;
		this.content_price = content_price;
		this.content_capacity = content_capacity;
		this.content_yn = content_yn;
		this.admin_email = admin_email;
		this.image_path = image_path;
	}



	@Override
	public String toString() {
		return "ContentListBO [content_no=" + content_no + ", content_name=" + content_name + ", content_info="
				+ content_info + ", content_price=" + content_price + ", content_capacity=" + content_capacity
				+ ", content_yn=" + content_yn + ", admin_email=" + admin_email + ", image_path=" + image_path + "]";
	}
	
	
	
}
