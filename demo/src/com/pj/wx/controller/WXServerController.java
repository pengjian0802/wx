package com.pj.wx.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pj.wx.dto.ItemDetailDto;
import com.pj.wx.service.ItemDetailService;
import com.pj.wx.service.ItemService;

@Controller
public class WXServerController {
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ItemDetailService itemDetailService;
	
	@RequestMapping("/toIndex")
	public String toIndex(){
		System.out.println("toIndex***********************************");
		return "index";
	}
	
	@RequestMapping("/save")
	public String save(HttpServletRequest request, ItemDetailDto itemDetailDto) throws ParseException, UnsupportedEncodingException {
		if (!StringUtils.isEmpty(request.getParameter("title"))) {
			String title = new String(request.getParameter("title").getBytes("iso-8859-1"),"utf-8");
			itemDetailDto.setTitle(title);
		}
		if (!StringUtils.isEmpty(request.getParameter("title"))) {
			String site = new String(request.getParameter("site").getBytes("iso-8859-1"),"utf-8");
			itemDetailDto.setSite(site);
		}
		if (!StringUtils.isEmpty(request.getParameter("title"))) {
			String participants = new String(request.getParameter("participants").getBytes("iso-8859-1"),"utf-8");
			itemDetailDto.setParticipants(participants);
		}
		if (!StringUtils.isEmpty(request.getParameter("title"))) {
			String remarks = new String(request.getParameter("remarks").getBytes("iso-8859-1"),"utf-8");
			itemDetailDto.setRemarks(remarks);
		}
		itemService.save(itemDetailDto);
		System.out.println("save***************************************");
		return "success";
	}
	
	@RequestMapping("/upLoadPage")
	public String upLoadPage(ItemDetailDto itemDetailDto) throws ParseException {
		System.out.println("upLoadPage***************************************");
		return "upLoadFile";
	}
}
