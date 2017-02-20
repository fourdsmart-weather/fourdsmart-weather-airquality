package com.fourdsmart.weather.airquality.dao;

import java.util.List;

import com.fourdsmart.weather.airquality.dao.entity.AqiBean;

/**
 * @author caojianfeng E-mail:caojianfeng@4dsmart.cn
 * @version 创建时间：Feb 14, 2017 2:13:12 PM 空气质量日报
 */
public interface AqiDao {

	public void saveDay(AqiBean aqiDayBeans);

	public void saveHour(AqiBean aqiDayBeans);
	
	public List<AqiBean> searchAqiDayDate(String date);
	
	public List<AqiBean> searchAqiHourDate(String date);

}
