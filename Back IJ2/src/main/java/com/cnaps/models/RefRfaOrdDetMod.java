package com.cnaps.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ref_rfa_ord_det")
public class RefRfaOrdDetMod{
	
	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQ")
//    @SequenceGenerator(name = "ID_SEQ", sequenceName = "seq_id_ref_ord_det")
	@Column(name = "id_ref_ord_det",nullable = false )
	private int id_ref_ord_det;
	
	@Column(name = "id_ref_rfa_ord", nullable = false )
	private int id_ref_rfa_ord;
	
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "qt")
	private String qt;
	
	
	@Column(name = "valide")
	private boolean valide;
	
	@Column(name = "total")
	private double total;

	public int getId_ref_ord_det() {
		return id_ref_ord_det;
	}

	public void setId_ref_ord_det(int id_ref_ord_det) {
		this.id_ref_ord_det = id_ref_ord_det;
	}

	public int getId_ref_rfa_ord() {
		return id_ref_rfa_ord;
	}

	public void setId_ref_rfa_ord(int id_ref_rfa_ord) {
		this.id_ref_rfa_ord = id_ref_rfa_ord;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	

	public String getQt() {
		return qt;
	}

	public void setQt(String qt) {
		this.qt = qt;
	}

	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
	

	

	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
