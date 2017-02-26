package com.adServer.model;

public class AdModel {
	
	public AdModel(){
	}
	
	public AdModel(String partner_id, int duration, String ad_content) {
		this.partner_id = partner_id;
		this.duration = duration;
		this.ad_content = ad_content;
	}
	
	private String partner_id;
	private int duration;
	private String ad_content;
	private long campaignCreationTime ;
	
	public String getPartner_id() {
		return partner_id;
	}
	public void setPartner_id(String partner_id) {
		this.partner_id = partner_id;
	}
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getAd_content() {
		return ad_content;
	}
	public void setAd_content(String ad_content) {
		this.ad_content = ad_content;
	}
	public long getCampaignCreationTime() {
		return campaignCreationTime;
	}
	
	public void setCampaignCreationTime(long campaignCreationTime) {
		this.campaignCreationTime = campaignCreationTime;
	}
	@Override
	public String toString() {
		return "AdModel [partner_id=" + partner_id + ", duration=" + duration + ", ad_content=" + ad_content
				+ ", campaignCreationTime=" + campaignCreationTime + "]";
	}
	


}


