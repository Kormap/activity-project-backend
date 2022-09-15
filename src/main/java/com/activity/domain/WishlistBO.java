package com.activity.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WishlistBO {
	
	private int content_no;
	private String content_name;
	private String content_info;
	private int content_price;
	private int content_capacity;
	private String content_yn;
	private String usr_id;
	private String image_path;
	private int wishlist_no;
	private String user_email;
	
	public WishlistBO() {}
	
	public WishlistBO(int content_no, String content_name, String content_info, int content_price, int content_capacity,
			String content_yn, String usr_id, String image_path, int wishlist_no, String user_email) {
		super();
		this.content_no = content_no;
		this.content_name = content_name;
		this.content_info = content_info;
		this.content_price = content_price;
		this.content_capacity = content_capacity;
		this.content_yn = content_yn;
		this.usr_id = usr_id;
		this.image_path = image_path;
		this.wishlist_no = wishlist_no;
		this.user_email = user_email;
	}

	@Override
	public String toString() {
		return "WishlistBO [content_no=" + content_no + ", content_name=" + content_name + ", content_info="
				+ content_info + ", content_price=" + content_price + ", content_capacity=" + content_capacity
				+ ", content_yn=" + content_yn + ", usr_id=" + usr_id + ", image_path=" + image_path + ", wishlist_no="
				+ wishlist_no + ", user_email=" + user_email + "]";
	}
	
	

}
