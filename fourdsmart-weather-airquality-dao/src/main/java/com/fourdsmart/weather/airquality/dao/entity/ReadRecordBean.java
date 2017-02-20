package com.fourdsmart.weather.airquality.dao.entity;


import java.util.Date;

import com.foursmart.weather.airquality.dao.utils.AqiType;

/**
 * @author caojianfeng E-mail:caojianfeng@4dsmart.cn
 * @version 创建时间：Feb 14, 2017 1:52:42 PM 空气质量
 */

public class ReadRecordBean {

	public String reportDate; // 数据发布时间
	public AqiType type; // 类型
	public Date createTime; //创建时间

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getReportDate() {
		return reportDate;
	}

	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}

	public AqiType getType() {
		return type;
	}

	public void setType(AqiType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ReadRecordBean [reportDate=" + reportDate + ", type=" + type + ", createTime=" + createTime + "]";
	}

}
