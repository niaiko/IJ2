package com.cnaps.services;




import java.util.List;

import com.cnaps.models.RefRfaOrdDetMod;
public interface RefRfaOrdDetService extends CRUDService<RefRfaOrdDetMod> {
	void save(List<RefRfaOrdDetMod> listRefRfaOrdDetMod);
	List<RefRfaOrdDetMod> findByIdOrdMere(int id_mere);
	List<RefRfaOrdDetMod> findByIdOrdMere(int id_mere, boolean service);
}
