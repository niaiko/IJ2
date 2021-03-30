package com.cnaps.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.cnaps.models.TecInfoRecuTraitMod;

public class UtilTraitementDateIJ2 {
	String dpa = "";
	String arret = "";
	String deces = "";
	String naissance = "";
	String reprise = "";
	
	
	
	public static java.util.Date convertFromSQLDateToJAVADate(java.sql.Date sqlDate) {     
        java.util.Date javaDate = null;
        if (sqlDate != null) {
            javaDate = new Date(sqlDate.getTime());
        }
        return javaDate;
    }
	public int differenceEntreDeuxDate(Date debut, Date fin) {

		final long MILLISECONDS_PER_DAY = 1000 * 60 * 60 * 24;
		long delta = 0;
		if (debut.before(fin)) {
			delta = fin.getTime() - debut.getTime();
		} else {
			delta = debut.getTime() - fin.getTime();
		}
		return (int) (delta / (MILLISECONDS_PER_DAY));
	}

	public double demisalaire(double salaire) {
		return salaire / 60;
	}

	public String getdate(List<TecInfoRecuTraitMod> liste, String nom) {
		int size = liste.size();
		String str = "";
		for (int i = 0; i < size; i++) {
			if (liste.get(i).getRefAccInfoTypMod().getAbbrev().equalsIgnoreCase(nom)) {
				str = liste.get(i).getValeur();
			}
		}
		return str;
	}
	

	public int prenatal(List<TecInfoRecuTraitMod> liste) throws Exception {
		int resultat = 0;
//		date naissance - date arret +1
//		Ou si date de décès avant la  DPA = date de décès – date d’arrêt + 1 jour
		dpa = getdate(liste, "DPA");
		arret = getdate(liste, "DAT");
		deces = getdate(liste, "DDC");
		naissance = getdate(liste, "DNA");
		Date datearret = convertStringToDateUtil(arret, "yyyy-MM-dd");
		Date datedpa = convertStringToDateUtil(dpa, "yyyy-MM-dd");
		Date datenaissance = convertStringToDateUtil(naissance, "yyyy-MM-dd");	
		if(deces.length()!=0) {
			Date datedeces = convertStringToDateUtil(deces, "yyyy-MM-dd");
			if(datedeces.before(datedpa)) {
				resultat = differenceEntreDeuxDate(datedeces, datearret) + 1;
			}
		}
		resultat = differenceEntreDeuxDate(datenaissance, datearret) + 1;
		if(resultat>=42) {
			resultat = 42;
		}
		
		return resultat;
	}

	public int postnatal(List<TecInfoRecuTraitMod> liste) throws Exception {
//		date reprise - date de naissance
//		date décé - date naissance
		int resultat = 56;
		deces = getdate(liste, "DDC");
		naissance = getdate(liste, "DNA");
		reprise = getdate(liste, "DRT");
		Date datenaissance = convertStringToDateUtil(naissance, "yyyy-MM-dd");
		Date datereprise = convertStringToDateUtil(reprise, "yyyy-MM-dd");
		Integer nbrej = differenceEntreDeuxDate(datereprise,datenaissance); 
		if(nbrej <= 56)
			resultat = nbrej;
		if (deces.length() != 0) {
			Date datedeces = convertStringToDateUtil(deces, "yyyy-MM-dd");
			int diff = differenceEntreDeuxDate(datedeces, datenaissance);
			if (diff <= 56) {
				resultat = diff;
			}
				
		}
		return resultat;
	}
	
	public int prolongation(List<TecInfoRecuTraitMod> liste) throws Exception{
		int resultat = 21;
		int prg = 0;
		String prol = getdate(liste, "PRG");
		if(prol!=null || prol.compareToIgnoreCase("") != 0 || Integer.parseInt(prol) != 0) {
			prg = Integer.parseInt(prol);
		}
		if(prg<=resultat) {
			resultat = prg;
		}
		return resultat;
	}
	
	public String referenceIJ1(List<TecInfoRecuTraitMod> liste) throws Exception{
		return getdate(liste,"REFIJ1");
	}
	
	
	public int nombre_jour_IJ1(List<TecInfoRecuTraitMod> liste) throws Exception{
		System.out.println("nbr jour : "+getdate(liste,"JRIJ1"));
		return Integer.parseInt(getdate(liste,"JRIJ1"));
	}

	public Date convertStringToDateUtil(String daty, String format) throws ParseException {
		DateFormat formatter = new SimpleDateFormat(format);
		Date retour = formatter.parse(daty);
		return retour;
	}

	public String convertDateToString(Date daty) throws Exception {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(daty);
	}

	public boolean endroit(List<TecInfoRecuTraitMod> liste) throws ParseException {
		dpa = getdate(liste, "DAT");
		Date datedpa = convertStringToDateUtil(dpa, "yyyy-MM-dd");
		Date aujourdhui = new Date();
		if (aujourdhui.before(datedpa)) {
			return true;
		}
		return differenceEntreDeuxDate(datedpa, aujourdhui) <= 365;
	}

	
	public Date DateMoinsJour(Date date, int nbjr) throws ParseException {
		
		Date daty = new Date(date.getTime() - (long)nbjr *1000 * 60 * 60 * 24);
		return daty;
	}

	public  Date DatePlusJour(Date date, int days) throws ParseException {
		UtilTraitementDateIJ2 util = new UtilTraitementDateIJ2();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String result = "";
		GregorianCalendar calendar = new java.util.GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, days);
		result = sdf.format(calendar.getTime());

		return util.convertStringToDateUtil(result, "yyyy-MM-dd");
	}

	public int nombreDeMoisEntreDeuxDate(Date debut, Date fin) {
		Calendar calStr1 = Calendar.getInstance();
		Calendar calStr2 = Calendar.getInstance();
		calStr1.setTime(debut);
		calStr2.setTime(fin);

		int nbMois = 0;
		while (calStr1.before(calStr2)) {
			calStr1.add(GregorianCalendar.MONTH, 1);
			if (calStr1.before(calStr2) || calStr1.equals(calStr2)) {
				nbMois++;
			}
		}
		return nbMois;
	}
	
	
	public List<TecInfoRecuTraitMod> concatenerIJ(List<TecInfoRecuTraitMod> IJ1, List<TecInfoRecuTraitMod> IJ2){
		IJ2.addAll(IJ1);
		return IJ2;
	}
	
	public static boolean isDouble(String str) throws Exception {
		try{
			Double.parseDouble(str);
			return true;
		}catch(Exception  e) {
			//throw new Exception("format incorrect : periode n'est pas un nombre");
			return false;
		}
	}
	public static double changeEnDouble(String valeur) {
		try {
			double montant = 0.0;
			boolean verif = isDouble(valeur);
			if(verif == true) {
				montant = Double.parseDouble(valeur);
			}else {
				String [] tab = valeur.split(",");
				montant = Double.parseDouble(tab[0]+"."+tab[1]);
			}
			return montant;
		}catch(Exception  e) {
			return 0;
		}
	}
}
