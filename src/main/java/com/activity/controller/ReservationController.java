package com.activity.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.activity.domain.ReservationInfoDTO;
import com.activity.service.ReservationService;

@Controller
@RestController
@RequestMapping("/api/reservation/*")
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;

	
	
	private static final Logger logger = LoggerFactory.getLogger(ContentController.class);
	
	
	//예약정보 리스트 조회
	@GetMapping("/infolist")
	public List<ReservationInfoDTO> getReservationInfoList() throws Exception { 
		
		List<ReservationInfoDTO> getReservationInfoList = reservationService.getReservationInfoList();
		
		return getReservationInfoList;
	}
	
	
	
	
	
	
//	//예약정보 리스트 조회 (테스트용)
//	//Map 의 경우 for 문이 동작할수 없음. 리스트 단건 조회 시 유용하게 사용가능 
//	@GetMapping("/infolist")
//	public ArrayList<HashMap<String, Object>> getReservationInfoList() throws Exception { 
//		
//		List<ReservationInfoDTO> getReservationInfoList = reservationService.getReservationInfoList();
//		System.out.println(getReservationInfoList);
//		
//		
//		ArrayList<HashMap<String, Object>> ReservationArray = new ArrayList<HashMap<String, Object>>();
//		HashMap<String, Object> ReservationMap = new LinkedHashMap<String, Object>();
//		
//		for(int i=0; i<getReservationInfoList.size(); i++) {
//			ReservationMap.put("예약번호", getReservationInfoList.get(i).getR_no());
//			ReservationMap.put("예약시간", getReservationInfoList.get(i).getR_time());
//			ReservationMap.put("예약인원", getReservationInfoList.get(i).getR_peopleCount());
//			ReservationMap.put("예약가", getReservationInfoList.get(i).getR_price());
//			ReservationMap.put("예약상태", getReservationInfoList.get(i).getR_status_yn());
//			ReservationArray.add(i,ReservationMap);
//		}
////		System.out.println("ReservationMap= " + ReservationMap);
//		System.out.println("ReservationArray =" +ReservationArray);
//		
//		
////		// Convert all Map keys to a List
////		List<String> result = new ArrayList(ReservationMap.keySet());
////
////		// Convert all Map values to a List
////		List<String> result2 = new ArrayList(ReservationMap.values());
////		System.out.println(result);
////		System.out.println(result2);
//		
////		for(int i=0; i<getReservationInfoList.size(); i++) {
////		System.out.println(getReservationInfoList.get(i).getR_no());
////		}
//		
//		
//		return ReservationArray;
//	}
	

}
