package com.foursmart.weather.airquality.dao.utils;

/**
 * @author caojianfeng E-mail:caojianfeng@4dsmart.cn
 * @version 创建时间：Feb 15, 2017 10:52:38 AM
 * @explain 类说明
 */
public enum AqiType {

	HOUR(0, "HOUR"), DAY(1, "DAY");

	private int code;

	private String name;

	AqiType(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public int getCode() {
		return this.code;
	}

	public String getName() {
		return this.name;
	}

	public static AqiType valueOfEnum(int code) {
		AqiType[] iss = values();
		for (AqiType cs : iss) {
			if (cs.getCode() == code) {
				return cs;
			}
		}
		return null;
	}
}
