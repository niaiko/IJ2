package com.cnaps.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ref_rfa_ord")
public class RefRfaOrdMod{
	
	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQ")
//    @SequenceGenerator(name = "ID_SEQ", sequenceName = "seq_id_ref_rfa_ord")
	@Column(name = "id_ref_rfa_ord",nullable = false )
	private int id_ref_rfa_ord;
	
	@Column(name = "id_acc", nullable = false )
	private String id_acc;
	
	@Column(name = "is_validate", nullable = false)
	private boolean is_validate;
	
	@Column(name = "observation", nullable = false)
	private String observation;

	public int getId_ref_rfa_ord() {
		return id_ref_rfa_ord;
	}

	public void setId_ref_rfa_ord(int id_ref_rfa_ord) {
		this.id_ref_rfa_ord = id_ref_rfa_ord;
	}

	public String getId_acc() {
		return id_acc;
	}

	public void setId_acc(String id_acc) {
		this.id_acc = id_acc;
	}

	public boolean isIs_validate() {
		return is_validate;
	}

	public void setIs_validate(boolean is_validate) {
		this.is_validate = is_validate;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
