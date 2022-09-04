package com.activity.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationInfoDTO {
	
	private int r_no;
	private String r_time;   //sql.timestamp 클래스 or String 클래스 
	private int r_peopleCount;
	private int r_price;
	private String r_status_yn;
	private String user_email;
	private int content_no;
	
	
	public ReservationInfoDTO(int r_no, String r_time, int r_peopleCount, int r_price, String r_status_yn,
			String user_email, int content_no) {
		super();
		this.r_no = r_no;
		this.r_time = r_time;
		this.r_peopleCount = r_peopleCount;
		this.r_price = r_price;
		this.r_status_yn = r_status_yn;
		this.user_email = user_email;
		this.content_no = content_no;
	}


	@Override
	public String toString() {
		return "ReservationInfoDTO [r_no=" + r_no + ", r_time=" + r_time + ", r_peopleCount=" + r_peopleCount
				+ ", r_price=" + r_price + ", r_status_yn=" + r_status_yn + ", user_email=" + user_email
				+ ", content_no=" + content_no + "]";
	}
	
	
	

}


//CREATE TABLE `reservationInfo` (
//`r_no`	INT NOT null auto_increment primary key,
//`r_time`	timestamp	not null default current_timestamp,
//`r_peopleCount`	INT	,
//`r_price`	INT	NULL,
//`r_status_yn`	VARCHAR(2)	NULL,
//`user_email`	VARCHAR(50)	NOT NULL,
//`content_no`	INT	NOT NULL
//);
