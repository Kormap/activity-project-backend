package com.activity.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WishlistDTO {
	
	private int wishlist_no; 
	private int content_no;
	private String user_email;
	
	public WishlistDTO() {}
	
	public WishlistDTO(int wishlist_no, int content_no, String user_email) {
		super();
		this.wishlist_no = wishlist_no;
		this.content_no = content_no;
		this.user_email = user_email;
	}

	@Override
	public String toString() {
		return "WishlistDTO [wishlist_no=" + wishlist_no + ", content_no=" + content_no + ", user_email=" + user_email
				+ "]";
	}
	
	
	
	
	

}
