package com.activity.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OptionDTO {
	
	private int option_no;
	private String option_name;
	private int content_no;
	
	
	public OptionDTO(int option_no, String option_name, int content_no) {
		super();
		this.option_no = option_no;
		this.option_name = option_name;
		this.content_no = content_no;
	}


	@Override
	public String toString() {
		return "OptionDTO [option_no=" + option_no + ", option_name=" + option_name + ", content_no=" + content_no
				+ "]";
	}
	
}
