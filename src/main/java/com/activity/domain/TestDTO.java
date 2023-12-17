package com.activity.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestDTO {
	
	private int image_no;
	private Object image_path; //데이터베이스 - blob 바이너리 타입 -> String 타입으로 
	private int content_no;
	private String image_type;
	
	public TestDTO() {

	}
	public TestDTO(int image_no, String image_path, int content_no, String image_type) {
		super();
		this.image_no = image_no;
		this.image_path = image_path;
		this.content_no = content_no;
		this.image_type = image_type;
	}

	@Override
	public String toString() {
		return "TestDTO [image_no=" + image_no + ", image_path=" + image_path + ", content_no=" + content_no
				+ ", image_type=" + image_type + "]";
	}


}
