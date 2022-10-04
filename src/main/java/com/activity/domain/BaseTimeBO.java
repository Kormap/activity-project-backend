package com.activity.domain;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseTimeBO {
	
	/** crtr_id (CRTR_ID) */
	private String crtr_id;
	/** crt_dttm (CRT_DTTM) */
	private Timestamp crt_dttm;
	/** updr_id (UPDR_ID) */
	private String updr_id;
	/** upd_dttm (UPD_DTTM) */
	private Timestamp upd_dttm;
	
	
	
}
