package com.activity.domain;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {
	
	//Category 테이블
	private int category_no;
	private String category_name;
	private String crtr_id;
	private Date crt_dttm; // datetime , current_timestamp
	private String updr_id;
	private Date upd_dttm;  // datetime , current_timestamp

}
