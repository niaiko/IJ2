package com.cnaps.models.param;

import com.cnaps.models.DecompteIJ2;

public class IJ2Param {
	DecompteIJ2 decompte = new DecompteIJ2();
	private double newdroitIJ1;
	private double newdroitIJ2;
	private double droitTotal;
	private double oldDroitIJ1;
	
	
	public DecompteIJ2 getDecompte() {
		return decompte;
	}
	public void setDecompte(DecompteIJ2 decompte) {
		this.decompte = decompte;
	}
	public double getNewdroitIJ1() {
		return newdroitIJ1;
	}
	public void setNewdroitIJ1(double newdroitIJ1) {
		this.newdroitIJ1 = newdroitIJ1;
	}
	public double getNewdroitIJ2() {
		return newdroitIJ2;
	}
	public void setNewdroitIJ2(double newdroitIJ2) {
		this.newdroitIJ2 = newdroitIJ2;
	}
	public double getDroitTotal() {
		return droitTotal;
	}
	public void setDroitTotal(double droitTotal) {
		this.droitTotal = droitTotal;
	}
	public double getOldDroitIJ1() {
		return oldDroitIJ1;
	}
	public void setOldDroitIJ1(double oldDroitIJ1) {
		this.oldDroitIJ1 = oldDroitIJ1;
	}
	
	
	
	
}
