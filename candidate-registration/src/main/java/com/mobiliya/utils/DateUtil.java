package com.mobiliya.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtil {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);
	
	private DateUtil() {
		//As this is utility class and all the method of this class are static so,
		//private constructor to restrict the instantiation
	}

	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
	
	public static Date parseDate(String stringDate) {
		if (stringDate == null) {
			return null;
		}
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
			return formatter.parse(stringDate);
		} catch (ParseException | IllegalArgumentException e) {
			//LOGGER.error("Exception :: ", e);
		}
		return null;
	}
}
