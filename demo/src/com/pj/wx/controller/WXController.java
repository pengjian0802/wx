package com.pj.wx.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.wx.dto.ItemDetailDto;
import com.pj.wx.dto.ItemDto;
import com.pj.wx.entity.Item;
import com.pj.wx.entity.ItemDetail;
import com.pj.wx.service.ItemDetailService;
import com.pj.wx.service.ItemService;

@Controller
public class WXController {

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ItemDetailService itemDetailService;

	@ResponseBody
	@RequestMapping(value = "/queryItem")
	public Map<String, List<ItemDto>> queryItem() {
		 Map<String, List<ItemDto>> result = new HashMap<String, List<ItemDto>>();
		 List<Item> items = itemService.findAllItems();
		 result.put("dataList", itemToDto(items));
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/queryItemDetail")
	public Map<String, ItemDetailDto> queryitemDetail(Long itemId){
		Map<String, ItemDetailDto> result = new HashMap<String, ItemDetailDto>();
		Item item = itemService.getById(itemId);
		List<ItemDetail> itemDetails = itemDetailService.findByItemId(itemId);
		result.put("itemDetail", itemDetailToDto(item, itemDetails));
		return result;
	}

	/**
	 * item页面组装
	 * @param items
	 * @return
	 */
	public List<ItemDto> itemToDto(List<Item> items) {
		List<ItemDto> dataList = new ArrayList<ItemDto>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		for (Item item : items) {
			ItemDto dto = new ItemDto();
			dto.setId(item.getId());
			dto.setTitle(item.getTitle());
			dto.setContent(item.getContent());
			dto.setImgUrl(itemDetailService.findByItemId(item.getId()).get(0).getImgUrl());
			dto.setDate(format.format(item.getDate()));
			dataList.add(dto);
		}
		return dataList;
	}

	public ItemDetailDto itemDetailToDto(Item item, List<ItemDetail> itemDetails) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		List<String> imgUrls = new ArrayList<String>();
		List<String> videoUrls = new ArrayList<String>();
		ItemDetailDto dto = new ItemDetailDto();
		dto.setItemId(item.getId());
		dto.setTitle(item.getTitle());
		for (ItemDetail itemDetail : itemDetails) {
			imgUrls.add(itemDetail.getImgUrl());
			videoUrls.add(itemDetail.getVideoUrl());
		}
		dto.setImgUrls(imgUrls);
		dto.setVideoUrls(videoUrls);
		dto.setStartTime(format.format(item.getStartTime()));
		dto.setEndTime(format.format(item.getEndTime()));
		dto.setSite(item.getSite());
		dto.setParticipants(item.getParticipants());
		dto.setRemarks(item.getRemarks());
		return dto;
	}
}
