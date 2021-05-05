package com.cnaps.services;



import java.util.Map;

import com.cnaps.models.DemandeIJMod;
import com.cnaps.models.param.DemandeFiltre;

public interface DemandeIJService {
	void enregistrerDemande(DemandeIJMod demandeIJMod,int etat,String token);
	public DemandeIJMod detailDemande(String id_acc);
	//public DemandeIJMod detailRfa(ParamRfaMod param);
	public boolean prolongationIJ2(DemandeIJMod demandeIJMod);
	Map<String,Object> listeRFA(DemandeFiltre param); 
}
