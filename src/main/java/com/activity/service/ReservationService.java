package com.activity.service;

import java.util.HashMap;
import java.util.List;

import com.activity.domain.ReservationHistoryBO;
import com.activity.domain.ReservationInfoDTO;

public interface ReservationService {

	
	//예약정보 리스트 조회 (테스트용) 
	public List<ReservationHistoryBO> getReservationInfoList(String user_email) throws Exception;
	
	//예약정보 저장 insert
	public void saveReservationInfo(ReservationInfoDTO reservationinfodto) throws Exception;

	//예약정보 취소 
	public void cancelReservation(int r_no);
	
	
}
