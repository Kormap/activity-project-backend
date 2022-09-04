package com.activity.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.activity.domain.ReservationInfoDTO;

@Repository
public class ReservationDAOImpl implements ReservationDAO {

	@Autowired
	private SqlSession sql;
	private static final String NAMESPACE = "com.activity.mybatis-mappers.ReservationMapper";
	@Override
	public List<ReservationInfoDTO> getReservationInfoList() throws Exception {

		return sql.selectList(NAMESPACE + ".getReservationInfoList");
	}
	
	
	
	
}
