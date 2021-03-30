package com.cnaps.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tec_pcs")
public class TecPcsMod{
	
	
	@Id
	@Column(name = "id_piece", unique = true , nullable = false )
	private String id_piece;
	
	@Column(name = "libelle", length = 50, nullable = false )
	private String libelle;
	
	@Column(name = "abrev", length = 10, nullable = true )
	private String abrev;
	
	
	public TecPcsMod(String id_piece) {
		super();
		this.id_piece = id_piece;
	}
	
	public TecPcsMod() {
		super();
	}

	public String getId_piece() {
		return id_piece;
	}

	public void setId_piece(String id_piece) {
		this.id_piece = id_piece;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getAbrev() {
		return abrev;
	}

	public void setAbrev(String abrev) {
		this.abrev = abrev;
	}

	
	
	
}
