package com.fourdsmart.weather.airquality.web.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fourdsmart.weather.airquality.dao.service.AqiService;
import com.foursmart.weather.airquality.dao.utils.AqiType;

/**
 * @author caojianfeng E-mail:caojianfeng@4dsmart.cn
 * @version 创建时间：Feb 15, 2017 2:20:39 PM
 * @explain 类说明
 */

@Controller
@RequestMapping("/aqiService")
public class AqiServiceApi {

	@Autowired
	private AqiService aqiService;

	@RequestMapping(value = "/searchAqiDataWithDate/{date}/{aqiType}", method = RequestMethod.GET)
	@ResponseBody
	public JSONResult<?> searchAqiDataWithDate(@PathVariable("date") String date,
			@PathVariable("aqiType") AqiType aqiType) {
		switch (aqiType) {
		case DAY:
			return new JSONResult<>(true, aqiService.searchAqiDayDate(date));
		case HOUR:
			return new JSONResult<>(true, aqiService.searchAqiHourDate(date));
		default:
			break;
		}

		return new JSONResult<>(false, "查检查接口参数问题");

	}

}
