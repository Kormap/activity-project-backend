package com.activity.dao;

import java.util.List;

import com.activity.domain.WishlistBO;
import com.activity.domain.WishlistDTO;

public interface WishlistDAO {

	//위시리스트 정보 삽입
	public void  saveWishlist(WishlistDTO wishlistdto) throws Exception;
	
	//위시리스트 정보 조회
	public List<WishlistBO> getWishlist(WishlistBO wishlistbo) throws Exception;

	//위시리스트 삭제
	public void deletewishlist(WishlistDTO wishlistdto);

	//위시리스트 중복 확인 
	public int checkDuplicateWishlist(WishlistDTO wishlistdto);
	
}
