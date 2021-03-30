package com.cnaps.utils;

public class CalculUtil {
	public double arroundSup(double montant) {
		double montantFinal = 0.0;
		return montantFinal;
	}
	
	public static long arrond(double droit) {
		long montant = Math.round(droit);
		String m = String.valueOf(montant);
		long resultat = 0;
		if(m.substring(m.length()-3).compareToIgnoreCase("000") > 0 ) {
			if(m.length() < 5) {
				int mil = Integer.valueOf(m.substring(0, 1))+1;
				resultat = (mil*1000);
			}else {
				int mil = Integer.valueOf(m.substring(0, 2))+1;
				resultat = (mil*1000);
			}
		}
		else if(m.substring(m.length()-3).compareToIgnoreCase("000") == 0) {
			if(m.length() < 5) {
				int mil = Integer.valueOf(m.substring(0, 1));
				resultat =  (mil*1000);
			}else {
				int mil = Integer.valueOf(m.substring(0, 2));
				resultat =  (mil*1000);
			}
		}
		return resultat;
	}
	
	public static Double convertDouble(String valeur) {
		Double resultat = 0.0;
		String [] res = valeur.split(",");
		if(res.length > 1)
			resultat = Double.parseDouble(res[0]+"."+res[1]);
		else
			resultat = Double.parseDouble(valeur);
		return resultat;
	}
	
	public long arrondPF(double droit) {
		long resultat = Math.round(droit);
		String montant = String.valueOf(Math.round(droit));
		if(montant.substring(montant.length()-3).compareToIgnoreCase("000") > 0) {
			String str = montant.substring(0,montant.length()-3);
			resultat = (Long.valueOf(str)+1)*1000;
		}
		return resultat;
	}
	
	
	public long arrondnewPF(double droit) {
		long resultat = Math.round(droit);
		String montant = String.valueOf(Math.round(droit));
		if(montant.substring(montant.length()-3).compareToIgnoreCase("000") >= 5) {
			String str = montant.substring(0,montant.length()-3);
			resultat = (Long.valueOf(str)+1)*1000;
		}else {
			String str = montant.substring(0,montant.length()-3);
			resultat = (Long.valueOf(str))*1000;
		}
		return resultat;
	}
}
