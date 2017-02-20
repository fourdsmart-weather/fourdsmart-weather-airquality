package com.fourdsmart.weather.api.quality.dao.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fourdsmart.weather.airquality.dao.entity.AqiBean;
import com.fourdsmart.weather.airquality.dao.service.AqiService;
import com.fourdsmart.weather.api.quality.dao.BaseTest;

/**
 * @author caojianfeng E-mail:caojianfeng@4dsmart.cn
 * @version 创建时间：Feb 15, 2017 9:22:56 AM
 * @explain 类说明
 */
public class AqiServiceTest extends BaseTest {

	@Autowired
	public AqiService aqiService;

	@Test
	public void testSaveAqiDayDate() {
		aqiService.saveAqiDayDate();
	}

	@Test
	public void testSaveAqiHourDate() {
		aqiService.saveAqiHourDate();
	}

	@Test
	public void testDateConvert() {
		String date = aqiService.dateConvert("2017年02月15日17时");
		System.out.println(date);
	}

	@Test
	public void testSearchAqiDayDate() {
		List<AqiBean> resutl = aqiService.searchAqiDayDate("2017-02-16");
		System.out.println(resutl.size());
	}

	@Test
	public void testSearchAqiHourDate() {
		List<AqiBean> resutl = aqiService.searchAqiHourDate("2017-02-15 11");
		System.out.println(resutl.size());

	}

}
