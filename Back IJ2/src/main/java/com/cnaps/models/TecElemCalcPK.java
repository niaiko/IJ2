package com.cnaps.models;

import java.io.Serializable;

public class TecElemCalcPK implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id_element;
	private String id_acc;
	public int getId_element() {
		return id_element;
	}
	public void setId_element(int id_element) {
		this.id_element = id_element;
	}
	public String getId_acc() {
		return id_acc;
	}
	public void setId_acc(String id_acc) {
		this.id_acc = id_acc;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
