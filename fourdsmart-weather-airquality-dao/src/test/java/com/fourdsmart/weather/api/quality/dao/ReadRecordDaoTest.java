package com.fourdsmart.weather.api.quality.dao;


import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fourdsmart.weather.airquality.dao.ReadRecordDao;
import com.fourdsmart.weather.airquality.dao.entity.ReadRecordBean;
import com.foursmart.weather.airquality.dao.utils.AqiType;

/**
 * @author caojianfeng E-mail:caojianfeng@4dsmart.cn
 * @version 创建时间：Feb 15, 2017 9:22:56 AM
 * @explain 类说明
 */
public class ReadRecordDaoTest extends BaseTest {

	@Autowired
	public ReadRecordDao readRecordDao;

	@Test
	public void testSave() {
		ReadRecordBean readRecordBean = new ReadRecordBean();
		readRecordBean.setReportDate("2017年02月15日07时");
		readRecordBean.setType(AqiType.HOUR);

		readRecordDao.save(readRecordBean);
	}

	@Test
	public void testGetReadRecordWithReportDate() {
		ReadRecordBean readRecordBean = readRecordDao.getReadRecordWithReportDate("2017年02月15日07时");
		System.out.println(readRecordBean);
	}
	
	@Test
	public void testGetAllData() {
		List<ReadRecordBean> resutl = readRecordDao.getAllData();
		System.out.println(resutl.size());
	}

}
