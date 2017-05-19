package com.pj.wx.entity;

import java.util.Date;

/**
 * 实体类Bean
 * @author pengjian2
 *
 */
public class Item {
	
	private Long id;
	
	private String title;
	
	private String content;
	
	private String imgUrl;
	
	/** 发布日期 **/
	private Date date;
	
	/** 开始时间 **/
	private Date startTime;
	
	/** 结束时间 **/
	private Date endTime;
	
	/** 地点 **/
	private String site;
	
	/** 参与人员 **/
	private String participants;
	
	/** 备注 **/
	private String remarks;
	
	/** 创建日期  **/
	private Date createTime;
	
	/** 创建者 **/
	private Integer createBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}
	
}
