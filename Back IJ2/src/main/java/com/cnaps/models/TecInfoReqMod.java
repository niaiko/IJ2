package com.cnaps.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(TecInfoReqPK.class)
@Table(name = "tec_info_req")
public class TecInfoReqMod {
	
	@Id
	@Column(name = "id_tec_dmd",nullable = false )
	private String id_tec_dmd;
	
	@Id
	@Column(name = "id_type_info", nullable = false )
	private int id_type_info;
	
	
 
	@Column(name = "flag_use", nullable = false )
	private String  flaguse;
	
	 
	
	public TecInfoReqMod(String id_tec_dmd, int id_type_info, String flaguse) {
		super();
		this.id_tec_dmd = id_tec_dmd;
		this.id_type_info = id_type_info;
		this.flaguse = flaguse;
	}

	public TecInfoReqMod() {
		super();
	}

	public String getId_tec_dmd() {
		return id_tec_dmd;
	}

	public void setId_tec_dmd(String id_tec_dmd) {
		this.id_tec_dmd = id_tec_dmd;
	}

	public int getId_type_info() {
		return id_type_info;
	}

	public void setId_type_info(int id_type_info) {
		this.id_type_info = id_type_info;
	}

	public String getFlaguse() {
		return flaguse;
	}

	public void setFlaguse(String flaguse) {
		this.flaguse = flaguse;
	}

	

	
}
