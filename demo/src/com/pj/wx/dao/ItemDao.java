package com.pj.wx.dao;

import java.util.List;

import com.pj.wx.entity.Item;


public interface ItemDao {
	
	List<Item> findAll();
	
	Item getById(Long id);
	
	void insert(Item item);
}
