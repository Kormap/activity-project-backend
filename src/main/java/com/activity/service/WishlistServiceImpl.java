package com.activity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activity.dao.WishlistDAO;
import com.activity.domain.WishlistBO;
import com.activity.domain.WishlistDTO;

@Service
public class WishlistServiceImpl implements WishlistService{

    @Autowired
    private WishlistDAO wishlistDAO;
    
    
    @Override
    public void saveWishlist(WishlistDTO wishlistdto) throws Exception {

        wishlistDAO.saveWishlist(wishlistdto);
    }
    

    @Override
    public List<WishlistBO> getWishlist(WishlistBO wishlistbo) throws Exception {

        return wishlistDAO.getWishlist(wishlistbo);
    }


    @Override
    public void deletewishlist(WishlistDTO wishlistdto) {
        
    	wishlistDAO.deletewishlist(wishlistdto);
        
    }


	@Override
	public int checkDuplicateWishlist(WishlistDTO wishlistdto) {
		return wishlistDAO.checkDuplicateWishlist(wishlistdto);
	}

}
