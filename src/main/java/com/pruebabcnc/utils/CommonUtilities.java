package com.pruebabcnc.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.pruebabcnc.exceptions.DateParserException;

public class CommonUtilities {
	public static final String YYYY_MM_DD_HH_MM_SS_HYPHEN_SEPARATOR = "yyyy-MM-dd HH:mm:ss";

	public static LocalDateTime parseFromString(String date, String format) throws DateParserException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		try {
			return LocalDateTime.parse(date, formatter);
		}catch(Exception e) {
			throw new DateParserException("La fecha introducida posee un formato incorrecto. Debe usar el formato yyyy-MM-dd HH:mm:ss");
		}
	}
}
