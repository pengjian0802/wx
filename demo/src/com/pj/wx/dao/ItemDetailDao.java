package com.pj.wx.dao;

import java.util.List;

import com.pj.wx.entity.ItemDetail;

public interface ItemDetailDao {
	
	List<ItemDetail> findByItemId(Long itemId);
	
	void insert(ItemDetail itemDetail);
}
