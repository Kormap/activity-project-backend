package com.activity.controller;

import java.util.HashMap;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.activity.domain.ReservationHistoryBO;
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
    @PostMapping("/infolist")
    public List<ReservationHistoryBO> getReservationInfoList(@RequestBody HashMap<String, Object> requestJsonHashMap) throws Exception { 
        
        String user_email = (String) requestJsonHashMap.get("user_email");
        List<ReservationHistoryBO> getReservationInfoList = reservationService.getReservationInfoList(user_email);
        return getReservationInfoList;
    }
    
    //예약정보 insert
    @PostMapping("/insert")
    public void saveReservationInfo(@RequestBody HashMap<String, Object> requestJsonHashMap, 
                                                  ReservationInfoDTO reservationinfodto) throws Exception {

//        reservationinfodto.setR_no(Integer.parseInt(requestJsonHashMap.get("r_no").toString()));
        reservationinfodto.setR_time(requestJsonHashMap.get("r_time").toString());
        reservationinfodto.setR_peoplecount(Integer.parseInt(requestJsonHashMap.get("r_peopleCount").toString()));
        reservationinfodto.setR_price(Integer.parseInt(requestJsonHashMap.get("r_price").toString()));
        reservationinfodto.setR_option(requestJsonHashMap.get("r_option").toString());
        reservationinfodto.setR_status_yn(requestJsonHashMap.get("r_status_yn").toString());
        reservationinfodto.setUser_email(requestJsonHashMap.get("user_email").toString());
        reservationinfodto.setContent_no(Integer.parseInt(requestJsonHashMap.get("content_no").toString()));
        reservationService.saveReservationInfo(reservationinfodto);
//        return reservationinfodto;
    }
    
    //예약정보 취소 (r_status_yn = Y ->N) UPDATE
    @PostMapping("/cancel")
    public void cancelReservation(@RequestBody HashMap<String, Object> requestJsonHashMap) throws Exception {
    	
    	int r_no = Integer.parseInt(requestJsonHashMap.get("Cancel_r_no").toString());
    	reservationService.cancelReservation(r_no);
    }
    
}



