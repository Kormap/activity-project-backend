package com.activity.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.activity.domain.ReservationHistoryBO;
import com.activity.domain.ReservationInfoDTO;

@Repository
public class ReservationDAOImpl implements ReservationDAO {

	@Autowired
	private SqlSession sql;
	private static final String NAMESPACE = "com.activity.mybatis-mappers.ReservationMapper";
	
	@Override
	public List<ReservationHistoryBO> getReservationInfoList(String user_email) throws Exception {
		
		System.out.println(sql.selectList(NAMESPACE + ".getReservationInfoList"));
		return sql.selectList(NAMESPACE + ".getReservationInfoList",user_email);
	}
	
	@Override
	public void saveReservationInfo(ReservationInfoDTO reservationinfodto) throws Exception {

		sql.insert(NAMESPACE + ".saveReservationInfo", reservationinfodto);
	}
	
	@Override
	public void cancelReservation(int r_no) {

		sql.update(NAMESPACE + ".cancelReservation", r_no);
	}
	
	
	
	
}
