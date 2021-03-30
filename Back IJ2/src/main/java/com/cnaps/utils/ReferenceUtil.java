package com.cnaps.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.cnaps.services.AccueilService;


public class ReferenceUtil {
	
	@Autowired
	AccueilService service;
	
	
	
	public  static String convertDateToString(Date daty) {
		DateFormat df = new SimpleDateFormat("ddMMyy");
		return df.format(daty);
	}
	
	public static  String getReferenceDemande(String prestation,long sequence,String DR){
		//Date daty = new Date();
		DateFormat df = new SimpleDateFormat("ddMMyy");
		String daty =df.format(Calendar.getInstance().getTime().getTime());
		//String datyy = convertDateToString(daty);
		return prestation+daty+String.format("%03d",sequence)+String.format("%02d",Integer.parseInt(DR));
	}
	
	public static String getDateNow(){
		DateFormat df = new SimpleDateFormat("dd/MM/yy");
		Date daty = new Date();
		
		return df.format(daty);
	}
	
	public static String itemCIE() {
		return "rep";
	}
	
	
}
