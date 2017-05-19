package com.pj.wx.dto;

import java.util.List;

/**
 * 页面展示dto
 * @author pengjian2
 *
 */
public class ItemDetailDto {
	
	private Long id;

	private Long itemId;

	private String title;

	private List<String> imgUrls;
	
	private List<String> videoUrls;
	
	/** 开始时间 **/
	private String startTime;
	
	/** 结束时间 **/
	private String endTime;
	
	/** 地点 **/
	private String site;
	
	/** 参与人员 **/
	private String participants;
	
	/** 备注 **/
	private String remarks;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getImgUrls() {
		return imgUrls;
	}

	public void setImgUrls(List<String> imgUrls) {
		this.imgUrls = imgUrls;
	}

	public List<String> getVideoUrls() {
		return videoUrls;
	}

	public void setVideoUrls(List<String> videoUrls) {
		this.videoUrls = videoUrls;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getParticipants() {
		return participants;
	}

	public void setParticipants(String participants) {
		this.participants = participants;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
