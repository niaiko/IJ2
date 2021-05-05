package com.cnaps.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(TecPcsReqPK.class)
@Table(name = "tec_pcs_req")
public class TecPcsReqMod {
	
	@Id
	@Column(name = "id_tec_dmd",nullable = false )
	private String id_tec_dmd;
	
	@Id
	@Column(name = "id_piece", nullable = false )
	private String id_piece;
	
	
	@Column(name = "flag_use", nullable = false )
	private String flaguse;
 
	
	public TecPcsReqMod() {
		super();
	}

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

	public String getFlaguse() {
		return flaguse;
	}

	public void setFlaguse(String flaguse) {
		this.flaguse = flaguse;
	}

	public TecPcsReqMod(String id_tec_dmd, String id_piece, String flaguse) {
		super();
		this.id_tec_dmd = id_tec_dmd;
		this.id_piece = id_piece;
		this.flaguse = flaguse;
	}

	

	

	
}
