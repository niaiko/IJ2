package com.cnaps.models;

import java.io.Serializable;

public class TecInfoRecuTraitModPK implements Serializable{
	

	private String id_acc;
	
	private RefAccInfoTypMod refAccInfoTypMod;

	public String getId_acc() {
		return id_acc;
	}

	public void setId_acc(String id_acc) {
		this.id_acc = id_acc;
	}

	public RefAccInfoTypMod getRefAccInfoTypMod() {
		return refAccInfoTypMod;
	}

	public void setRefAccInfoTypMod(RefAccInfoTypMod refAccInfoTypMod) {
		this.refAccInfoTypMod = refAccInfoTypMod;
	}
	
	

	
	
	
	
}
