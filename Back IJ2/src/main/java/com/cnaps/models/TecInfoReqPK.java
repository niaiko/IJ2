package com.cnaps.models;

import java.io.Serializable;

public class TecInfoReqPK implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id_tec_dmd;
	private int id_type_info;
	
	public int getId_type_info() {
		return id_type_info;
	}
	public void setId_type_info(int id_type_info) {
		this.id_type_info = id_type_info;
	}
	public int getId_tec_dmd() {
		return id_tec_dmd;
	}
	public void setId_tec_dmd(int id_tec_dmd) {
		this.id_tec_dmd = id_tec_dmd;
	}
	
	
}
