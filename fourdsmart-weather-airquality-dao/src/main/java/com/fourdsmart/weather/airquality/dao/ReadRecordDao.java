package com.fourdsmart.weather.airquality.dao;

import java.util.List;

import com.fourdsmart.weather.airquality.dao.entity.ReadRecordBean;

/**
 * @author caojianfeng E-mail:caojianfeng@4dsmart.cn
 * @version 创建时间：Feb 14, 2017 2:13:12 PM 空气质量日报
 */
public interface ReadRecordDao {

	public void save(ReadRecordBean readRecordBean);

	public ReadRecordBean getReadRecordWithReportDate(String reportDate);

	public List<ReadRecordBean> getAllData();

}
