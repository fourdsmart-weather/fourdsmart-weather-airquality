package com.foursmart.weather.airquality.dao.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fourdsmart.weather.airquality.dao.service.AqiService;

/**
 * @author caojianfeng E-mail:caojianfeng@4dsmart.cn
 * @version 创建时间：Feb 15, 2017 1:32:16 PM
 * @explain 类说明
 */
@Component
public class AqiTask {

	@Autowired
	public AqiService aqiService;

	public void start() {

		aqiService.saveAqiDayDate();
		aqiService.saveAqiHourDate();

	}

}
