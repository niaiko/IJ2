package com.cnaps.services;




import com.cnaps.models.RefRfaOrdMod;




public interface RefRfaOrdService extends CRUDService<RefRfaOrdMod> {
	RefRfaOrdMod findByIdAccueil(String id_acc);
}
