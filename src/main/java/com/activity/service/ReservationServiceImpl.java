package com.activity.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.activity.dao.ReservationDAO;
import com.activity.domain.ReservationHistoryBO;
import com.activity.domain.ReservationInfoDTO;

@Service
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	private ReservationDAO reservationdao;

	@Override
	public List<ReservationHistoryBO> getReservationInfoList(String user_email) throws Exception {

		return reservationdao.getReservationInfoList(user_email);
	}

	@Override
	public void saveReservationInfo(ReservationInfoDTO reservationinfodto) throws Exception {
		
	
		reservationdao.saveReservationInfo(reservationinfodto);
	}

	@Override
	public void cancelReservation(int r_no) {

		reservationdao.cancelReservation(r_no);
	}
	
	
}
