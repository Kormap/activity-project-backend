package com.activity.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.activity.domain.WishlistBO;
import com.activity.domain.WishlistDTO;

@Repository
public class WishlistDAOImpl implements WishlistDAO {

	@Autowired
	private SqlSession sql;
	private static final String NAMESPACE = "com.activity.mybatis-mappers.WishlistMapper";
	
	
	@Override
	public void saveWishlist(WishlistDTO wishlistdto) throws Exception {
		
		sql.insert(NAMESPACE + ".saveWishlist", wishlistdto);
	}


	@Override
	public List<WishlistBO> getWishlist(WishlistBO wishlistbo) throws Exception {

		return sql.selectList(NAMESPACE + ".getWishlist",wishlistbo);
	}


	@Override
	public void deletewishlist(WishlistDTO wishlistdto) {

		sql.delete(NAMESPACE + ".deletewishlist", wishlistdto);
	}


	@Override
	public int checkDuplicateWishlist(WishlistDTO wishlistdto) {

		return sql.selectOne(NAMESPACE + ".checkDuplicateWishlist", wishlistdto);
	}

	
}
