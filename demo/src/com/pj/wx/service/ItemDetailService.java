package com.pj.wx.service;

import java.util.List;

import com.pj.wx.entity.ItemDetail;

public interface ItemDetailService {

	public List<ItemDetail> findByItemId(Long itemId);
	
	public void save(ItemDetail itemDetail);
}
