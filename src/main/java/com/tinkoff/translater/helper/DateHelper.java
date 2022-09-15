package com.tinkoff.translater.helper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateHelper {
	public static Date getCurrentDate() {
		return new Date(System.currentTimeMillis());
	}
}
