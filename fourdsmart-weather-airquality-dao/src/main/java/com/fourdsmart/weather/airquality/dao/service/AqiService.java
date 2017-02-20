package com.fourdsmart.weather.airquality.dao.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fourdsmart.weather.airquality.dao.AqiDao;
import com.fourdsmart.weather.airquality.dao.ReadRecordDao;
import com.fourdsmart.weather.airquality.dao.entity.AqiBean;
import com.fourdsmart.weather.airquality.dao.entity.ReadRecordBean;
import com.foursmart.weather.airquality.dao.utils.AqiType;

/**
 * @author caojianfeng E-mail:caojianfeng@4dsmart.cn
 * @version 创建时间：Feb 15, 2017 9:19:14 AM
 * @explain 类说明
 */
@Component
public class AqiService {

	private static Logger logger = LoggerFactory.getLogger(AqiService.class);

	public final String aqiDayUrl = "http://datacenter.mep.gov.cn:8099/aqiweb2/";

	@Autowired
	public ReadRecordDao readRecordDao;

	@Autowired
	public AqiDao aqiDao;

	@Transactional
	public void saveAqiDayDate() {

		Document doc = null;
		try {
			doc = Jsoup.connect(aqiDayUrl).get();
			Elements aqiDayData = doc.select("#demo1 #demo1_table td");
			Elements time = doc.select(".tabtime");

			ReadRecordBean readRecordBean = readRecordDao.getReadRecordWithReportDate(time.get(0).text());
			if (readRecordBean != null) {
				logger.info("{} 空气质量日报已存在,无须抓取!", time.get(0).text());
				return;
			}

			// 每四一个循环，进行数据封装
			for (int i = 0; i < aqiDayData.size(); i = i + 4) {

				// 1.获取四条数据
				Element element1 = aqiDayData.get(i);
				Element element2 = aqiDayData.get(i + 1);
				Element element3 = aqiDayData.get(i + 2);
				Element element4 = aqiDayData.get(i + 3);

				// 2.提取四条数据的内容
				String city = element1.text();
				int aqi = Integer.parseInt(element2.text());
				String level = element3.text();
				String primaryPollutant = element4.text();
				String date = this.dateConvert(time.get(0).text());

				// 3.创建bean
				AqiBean aqiDayBean = new AqiBean();
				aqiDayBean.setAqi(aqi);
				aqiDayBean.setLevel(level);
				aqiDayBean.setPrimaryPollutant(primaryPollutant);
				aqiDayBean.setCity(city);
				aqiDayBean.setDate(date.toString());

				// 4.插入数据库
				aqiDao.saveDay(aqiDayBean);
				logger.info("{} insert seccess!", aqiDayBean);
			}

			// 5. 查询记入表
			ReadRecordBean readRecordDay = new ReadRecordBean();
			readRecordDay.setReportDate(time.get(0).text());
			readRecordDay.setType(AqiType.DAY);
			readRecordDao.save(readRecordDay);
			logger.info("{} insert seccess!", readRecordDay);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Transactional
	public void saveAqiHourDate() {

		Document doc = null;
		try {
			doc = Jsoup.connect(aqiDayUrl).get();
			Elements aqiDayData = doc.select("#demo1_1 #demo1_1_table td");
			Elements time = doc.select(".tabtime");

			ReadRecordBean readRecordBean = readRecordDao.getReadRecordWithReportDate(time.get(1).text());
			if (readRecordBean != null) {
				logger.info("{} 空气质量小时报已存在,无须抓取!", time.get(1).text());
				return;
			}

			// 每四一个循环，进行数据封装
			for (int i = 0; i < aqiDayData.size(); i = i + 4) {

				// 1.获取四条数据
				Element element1 = aqiDayData.get(i);
				Element element2 = aqiDayData.get(i + 1);
				Element element3 = aqiDayData.get(i + 2);
				Element element4 = aqiDayData.get(i + 3);

				// 2.提取四条数据的内容
				String title = element1.attr("title");
				String city = element1.text();
				int aqi = Integer.parseInt(element2.text());
				String level = element3.text();
				String primaryPollutant = element4.text();
				String date = this.dateConvert(time.get(1).text());

				// 3.创建bean
				AqiBean aqiDayBean = new AqiBean();
				aqiDayBean.setIndex(title);
				aqiDayBean.setAqi(aqi);
				aqiDayBean.setLevel(level);
				aqiDayBean.setPrimaryPollutant(primaryPollutant);
				aqiDayBean.setCity(city);
				aqiDayBean.setDate(date.toString());

				// 4.插入数据库
				aqiDao.saveHour(aqiDayBean);
				logger.info("{} insert seccess!", aqiDayBean);

			}

			// 5. 查询记入表
			ReadRecordBean readRecordDay = new ReadRecordBean();
			readRecordDay.setReportDate(time.get(1).text());
			readRecordDay.setType(AqiType.HOUR);
			readRecordDao.save(readRecordDay);
			logger.info("{} insert seccess!", readRecordDay);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String dateConvert(String dateString) {
		String resutl = null;
		String simpleDateFormartStr = "";
		if (dateString.length() > 12) {
			simpleDateFormartStr = "yyyy年MM月dd日HH时";
		} else {
			simpleDateFormartStr = "yyyy年MM月dd日";
		}

		try {
			SimpleDateFormat sdf = new SimpleDateFormat(simpleDateFormartStr);
			Date date = sdf.parse(dateString);

			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			resutl = sdf1.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return resutl;
	}

	public List<AqiBean> searchAqiDayDate(String date) {
		return aqiDao.searchAqiDayDate(date);
	}

	public List<AqiBean> searchAqiHourDate(String date) {
		return aqiDao.searchAqiHourDate(date);
	}

}
