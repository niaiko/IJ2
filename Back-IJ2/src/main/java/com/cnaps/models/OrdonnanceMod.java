package com.cnaps.models;

import java.util.List;

public class OrdonnanceMod {

	private RefRfaOrdMod ordMere;
	private List<RefRfaOrdDetMod> ordFille;
	
	public RefRfaOrdMod getOrdMere() {
		return ordMere;
	}
	public void setOrdMere(RefRfaOrdMod ordMere) {
		this.ordMere = ordMere;
	}
	public List<RefRfaOrdDetMod> getOrdFille() {
		return ordFille;
	}
	public void setOrdFille(List<RefRfaOrdDetMod> ordFille) {
		this.ordFille = ordFille;
	}
	
	
	
}
