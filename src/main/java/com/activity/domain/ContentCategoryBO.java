package com.activity.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContentCategoryBO {

	private int content_no;
	private String content_name;
	private String content_info;
	private int content_price;
	private int content_capacity;
	private String content_yn;
	private String usr_id;
	private String category_name;
	//Image 테이블 
	private String image_path;

	public ContentCategoryBO(int content_no, String content_name, String content_info, int content_price,
			int content_capacity, String content_yn, String usr_id, String category_name, String image_path) {
		super();
		this.content_no = content_no;
		this.content_name = content_name;
		this.content_info = content_info;
		this.content_price = content_price;
		this.content_capacity = content_capacity;
		this.content_yn = content_yn;
		this.usr_id = usr_id;
		this.category_name = category_name;
		this.image_path = image_path;
	}

	@Override
	public String toString() {
		return "ContentCategoryBO [content_no=" + content_no + ", content_name=" + content_name + ", content_info="
				+ content_info + ", content_price=" + content_price + ", content_capacity=" + content_capacity
				+ ", content_yn=" + content_yn + ", usr_id=" + usr_id + ", category_name=" + category_name
				+ ", image_path=" + image_path + "]";
	}
	
	

}
