package com.cnaps.utils;

import java.time.LocalDate;
import java.util.Calendar;

import com.sun.el.parser.ParseException;

public class DateUtil {
	public static java.sql.Date sqlDateNow() {
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}
	public static java.sql.Date[] getTroisQuatreMois(java.sql.Date dpa)throws ParseException {
		java.sql.Date[] dateRetour = new java.sql.Date[2];
		Calendar calendar4 = Calendar.getInstance();
		calendar4.setTime(dpa);
		calendar4.add(Calendar.DATE, -1);
		calendar4.add(Calendar.MONTH, -5); // 4 e mois
		Calendar calendar3 = Calendar.getInstance();
		calendar3.setTime(dpa);
		calendar3.add(Calendar.DATE, -1);
		calendar3.add(Calendar.MONTH, -6); // 3 e mois
		dateRetour[0] = new java.sql.Date(calendar3.getTime().getTime());
		dateRetour[1] = new java.sql.Date(calendar4.getTime().getTime());
		return dateRetour;
	}
	
	public static java.sql.Date getFinNextMois(java.sql.Date date)throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		java.sql.Date dat = new java.sql.Date(calendar.getTime().getTime());
		LocalDate daty = dat.toLocalDate();
		calendar.setTime(dat);
		calendar.set(Calendar.DATE, daty.lengthOfMonth());
		return new java.sql.Date(calendar.getTimeInMillis());
	}
}
