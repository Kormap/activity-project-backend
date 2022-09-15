package com.activity.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.activity.domain.WishlistBO;
import com.activity.domain.WishlistDTO;
import com.activity.service.WishlistService;

@Controller
@RestController
@RequestMapping("/api/wishlist/*")
public class WishlistController {

	@Autowired
	private WishlistService wishlistService;
	
	private static final Logger logger = LoggerFactory.getLogger(ContentController.class);

	@PostMapping("insert")
	public int saveWishlist(@RequestBody HashMap<String, Object> requestJsonHashMap,WishlistDTO wishlistdto) throws Exception{ 
		
		wishlistdto.setContent_no(Integer.parseInt(requestJsonHashMap.get("content_no").toString()));
		wishlistdto.setUser_email(requestJsonHashMap.get("user_email").toString());
		int result = wishlistService.checkDuplicateWishlist(wishlistdto);
		if(result == 0) {
			wishlistService.saveWishlist(wishlistdto);
		}
		
		return result;
		
	}
	
	@PostMapping("getwishlist")
	public List<WishlistBO> getWishlist(@RequestBody HashMap<String, Object> requestJsonHashMap,WishlistBO wishlistbo) throws Exception {
		
		wishlistbo.setUser_email(requestJsonHashMap.get("user_email").toString());
		List<WishlistBO> getWishlist = wishlistService.getWishlist(wishlistbo);
		
		return getWishlist;
	}
	
	@PostMapping("deletewishlist")
	public void deletewishlist(@RequestBody HashMap<String, Object> requestJsonHashMap,WishlistDTO wishlistdto) throws Exception{ 
		
		wishlistdto.setWishlist_no(Integer.parseInt(requestJsonHashMap.get("wishlist_no").toString()));
		wishlistdto.setContent_no(Integer.parseInt(requestJsonHashMap.get("content_no").toString()));
		wishlistdto.setUser_email(requestJsonHashMap.get("user_email").toString());
		wishlistService.deletewishlist(wishlistdto);
	}
}
