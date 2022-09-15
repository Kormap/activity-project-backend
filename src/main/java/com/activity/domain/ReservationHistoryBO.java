package com.activity.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationHistoryBO {

	private int r_no;
	private String r_time;   //sql.timestamp 클래스 or String 클래스 
	private int r_peoplecount;
	private int r_price;
	private String r_option;
	private String r_status_yn;
	private String user_email;
	private int content_no;
	private String content_name; //JOIN , 해당 DTO 는 예약내역페이지에서만 사용됨 
	
	public ReservationHistoryBO() {}

	public ReservationHistoryBO(int r_no, String r_time, int r_peoplecount, int r_price, String r_option,
			String r_status_yn, String user_email, int content_no, String content_name) {
		super();
		this.r_no = r_no;
		this.r_time = r_time;
		this.r_peoplecount = r_peoplecount;
		this.r_price = r_price;
		this.r_option = r_option;
		this.r_status_yn = r_status_yn;
		this.user_email = user_email;
		this.content_no = content_no;
		this.content_name = content_name;
	}

	@Override
	public String toString() {
		return "ReservationHistoryBO [r_no=" + r_no + ", r_time=" + r_time + ", r_peoplecount=" + r_peoplecount
				+ ", r_price=" + r_price + ", r_option=" + r_option + ", r_status_yn=" + r_status_yn + ", user_email="
				+ user_email + ", content_no=" + content_no + ", content_name=" + content_name + "]";
	}
	
	
}
