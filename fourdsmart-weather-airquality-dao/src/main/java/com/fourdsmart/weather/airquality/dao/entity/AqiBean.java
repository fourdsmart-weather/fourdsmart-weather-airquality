package com.fourdsmart.weather.airquality.dao.entity;


/**
 * @author caojianfeng E-mail:caojianfeng@4dsmart.cn
 * @version 创建时间：Feb 14, 2017 1:52:42 PM 空气质量
 */
public class AqiBean {

	private String city; // 城市
	private String level; // 级别
	private int aqi; // AQI数据
	private String date; // 日期
	private String primaryPollutant; // 首要污染物
	private String index; // 指数说明
	private String createTime;// 创建时间

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getAqi() {
		return aqi;
	}

	public void setAqi(int aqi) {
		this.aqi = aqi;
	}

	public String getPrimaryPollutant() {
		return primaryPollutant;
	}

	public void setPrimaryPollutant(String primaryPollutant) {
		this.primaryPollutant = primaryPollutant;
	}

	@Override
	public String toString() {
		return "AqiBean [city=" + city + ", level=" + level + ", aqi=" + aqi + ", date=" + date + ", primaryPollutant="
				+ primaryPollutant + ", index=" + index + ", createTime=" + createTime + "]";
	}


}
