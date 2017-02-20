package com.fourdsmart.weather.api.quality.dao;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fourdsmart.weather.airquality.dao.AqiDao;
import com.fourdsmart.weather.airquality.dao.entity.AqiBean;

/**
 * @author caojianfeng E-mail:caojianfeng@4dsmart.cn
 * @version 创建时间：Feb 14, 2017 5:11:11 PM
 * @explain 测试类
 */
public class AqiDaoTest extends BaseTest {

	@Autowired
	public AqiDao aqiDayDao;

	@Test
	public void testSaveDay() {
		AqiBean aqiDayBean = new AqiBean();
		aqiDayBean.setCity("city");

		aqiDayDao.saveDay(aqiDayBean);

	}

}
