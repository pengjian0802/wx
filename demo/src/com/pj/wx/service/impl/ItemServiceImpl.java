package com.pj.wx.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pj.wx.dao.ItemDao;
import com.pj.wx.dto.ItemDetailDto;
import com.pj.wx.entity.Item;
import com.pj.wx.service.ItemService;

@Service("itemService")
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemDao dao;

	@Override
	public List<Item> findAllItems() {
		return dao.findAll();
	}

	@Override
	public Item getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void save(ItemDetailDto itemDetailDto) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Item item = new Item();
		item.setId(itemDetailDto.getId());
		item.setTitle(itemDetailDto.getTitle());
		item.setStartTime(format.parse(itemDetailDto.getStartTime()));
		item.setEndTime(format.parse(itemDetailDto.getEndTime()));
		item.setDate(new Date());
		item.setContent(itemDetailDto.getRemarks());
		item.setSite(itemDetailDto.getSite());
		item.setParticipants(itemDetailDto.getParticipants());
		item.setRemarks(itemDetailDto.getRemarks());
		item.setCreateBy(1);
		item.setCreateTime(new Date());
		dao.insert(item);
	}

}
