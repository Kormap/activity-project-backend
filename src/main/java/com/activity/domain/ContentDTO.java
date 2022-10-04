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
	private String usr_id;
	private String content_end_date;
	
	//Content_Option 테이블 넣을지.. DTO 를 만들지..
	
	
	//생성자 
	public ContentDTO(int content_no, String content_name, String content_info, int content_price, int content_capacity,
			String content_yn, String usr_id, String content_end_date) {
		super();
		this.content_no = content_no;
		this.content_name = content_name;
		this.content_info = content_info;
		this.content_price = content_price;
		this.content_capacity = content_capacity;
		this.content_yn = content_yn;
		this.usr_id = usr_id;
		this.content_end_date = content_end_date;
	}

	@Override
	public String toString() {
		return "ContentDTO [content_no=" + content_no + ", content_name=" + content_name + ", content_info="
				+ content_info + ", content_price=" + content_price + ", content_capacity=" + content_capacity
				+ ", content_yn=" + content_yn + ", usr_id=" + usr_id + ", content_end_date=" + content_end_date + "]";
	}
	
	
}
