package com.cnaps.models.param;

public class DemandeParam {
	private FiltreDmd filtre;
	private int pagination;
	private int taille;
	
	public FiltreDmd getFiltre() {
		return filtre;
	}
	public void setFiltre(FiltreDmd filtre) {
		this.filtre = filtre;
	}
	public int getPagination() {
		return pagination;
	}
	public void setPagination(int pagination) {
		this.pagination = pagination;
	}
}
