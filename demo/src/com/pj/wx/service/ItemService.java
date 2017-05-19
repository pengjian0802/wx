package com.pj.wx.service;

import java.text.ParseException;
import java.util.List;

import com.pj.wx.dto.ItemDetailDto;
import com.pj.wx.entity.Item;

public interface ItemService {
	
	public List<Item> findAllItems();
	
	public Item getById(Long id);
	
	public void save(ItemDetailDto ItemDetailDto) throws ParseException;
}
