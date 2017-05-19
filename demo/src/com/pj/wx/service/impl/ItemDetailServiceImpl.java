package com.pj.wx.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pj.wx.dao.ItemDetailDao;
import com.pj.wx.entity.ItemDetail;
import com.pj.wx.service.ItemDetailService;

@Service("itemDetailService")
public class ItemDetailServiceImpl implements ItemDetailService {
	
	@Autowired
	private ItemDetailDao dao;

	@Override
	public List<ItemDetail> findByItemId(Long itemId) {
		return dao.findByItemId(itemId);
	}

	@Override
	public void save(ItemDetail itemDetail) {
		itemDetail.setCreateTime(new Date());
		dao.insert(itemDetail);
	}

}
