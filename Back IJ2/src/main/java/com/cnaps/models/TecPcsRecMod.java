package com.cnaps.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(TecPcsRecPK.class)
@Table(name = "tec_pcs_rec")
public class TecPcsRecMod {

	@Id
	@Column(name = "id_acc", unique = true, nullable = false)
	private String id_acc;

	@Id
	@Column(name = "id_piece", unique = true, nullable = false)
	private String id_piece;

	@Column(name = "liens_fichier", nullable = false)
	private String liens_fichier;

	@Column(name = "num_pcs", nullable = false)
	private String numpcs ;

	public String getId_acc() {
		return id_acc;
	}

	public void setId_acc(String id_acc) {
		this.id_acc = id_acc;
	}

	public String getId_piece() {
		return id_piece;
	}

	public void setId_piece(String id_piece) {
		this.id_piece = id_piece;
	}

	public String getLiens_fichier() {
		return liens_fichier;
	}

	public void setLiens_fichier(String liens_fichier) {
		this.liens_fichier = liens_fichier;
	}

	public String getNumpcs() {
		return numpcs;
	}

	public void setNumpcs(String numpcs) {
		if (numpcs.compareTo("") == 0)
			this.numpcs = "0";
		else {
			this.numpcs = numpcs;
		}
	}

}
