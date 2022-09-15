package com.activity.domain;


import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationInfoDTO {
	
	private int r_no;
	private String r_time;   //sql.timestamp 클래스 or String 클래스 
	private int r_peoplecount;
	private int r_price;
	private String r_option;
	private String r_status_yn;
	private String user_email;
	private int content_no;
//	private String content_name; //JOIN , 해당 DTO 는 예약내역페이지에서만 사용됨 
	private String crtr_id;
	private Date crt_dttm; // datetime , current_timestamp
	private String updr_id;
	private Date upd_dttm;  // datetime , current_timestamp
	
	public ReservationInfoDTO() {}



	public ReservationInfoDTO(int r_no, String r_time, int r_peoplecount, int r_price, String r_option,
			String r_status_yn, String user_email, int content_no, String crtr_id, Date crt_dttm, String updr_id,
			Date upd_dttm) {
		super();
		this.r_no = r_no;
		this.r_time = r_time;
		this.r_peoplecount = r_peoplecount;
		this.r_price = r_price;
		this.r_option = r_option;
		this.r_status_yn = r_status_yn;
		this.user_email = user_email;
		this.content_no = content_no;
		this.crtr_id = crtr_id;
		this.crt_dttm = crt_dttm;
		this.updr_id = updr_id;
		this.upd_dttm = upd_dttm;
	}

	@Override
	public String toString() {
		return "ReservationInfoDTO [r_no=" + r_no + ", r_time=" + r_time + ", r_peoplecount=" + r_peoplecount
				+ ", r_price=" + r_price + ", r_option=" + r_option + ", r_status_yn=" + r_status_yn + ", user_email="
				+ user_email + ", content_no=" + content_no + ", crtr_id=" + crtr_id + ", crt_dttm=" + crt_dttm
				+ ", updr_id=" + updr_id + ", upd_dttm=" + upd_dttm + "]";
	}





	
	


}


//CREATE TABLE `reservationInfo` (
//`r_no`	INT NOT null auto_increment primary key,
//`r_time`	timestamp	not null default current_timestamp,
//`r_peoplecount`	INT	,
//`r_price`	INT	NULL,
//`r_status_yn`	VARCHAR(2)	NULL,
//`user_email`	VARCHAR(50)	NOT NULL,
//`content_no`	INT	NOT NULL
//);
