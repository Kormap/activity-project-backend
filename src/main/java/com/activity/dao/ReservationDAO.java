package com.activity.dao;

import java.util.List;

import com.activity.domain.ReservationHistoryBO;
import com.activity.domain.ReservationInfoDTO;

public interface ReservationDAO {

	//예약정보 리스트 조회 (테스트용) 
	public List<ReservationHistoryBO> getReservationInfoList(String user_email) throws Exception;
	
	//예약정보 저장 insert
	public void saveReservationInfo(ReservationInfoDTO reservationinfodto) throws Exception;

	//예약정보 취소 (업데이트) 
	public void cancelReservation(int r_no);

	//예약 갯수(회원삭제시)
	public int selectUserReservation(String user_email);
	
}


