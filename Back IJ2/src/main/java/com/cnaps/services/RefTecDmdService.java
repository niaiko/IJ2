package com.cnaps.services;

import java.util.List;

import com.cnaps.models.RefTecDmdMod;

public interface RefTecDmdService extends CRUDService<RefTecDmdMod> {
	RefTecDmdMod getById_tec_dmd(String id_tec_dmd);
	List<RefTecDmdMod> getAllPrestationPF(String prestation);
}
