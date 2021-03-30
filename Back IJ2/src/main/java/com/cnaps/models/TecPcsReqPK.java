package com.cnaps.models;

import java.io.Serializable;

public class TecPcsReqPK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id_tec_dmd;
	private String id_piece;
	
	
	public String getId_tec_dmd() {
		return id_tec_dmd;
	}
	public void setId_tec_dmd(String id_tec_dmd) {
		this.id_tec_dmd = id_tec_dmd;
	}
	public String getId_piece() {
		return id_piece;
	}
	public void setId_piece(String id_piece) {
		this.id_piece = id_piece;
	}
	
	
	
	
}
