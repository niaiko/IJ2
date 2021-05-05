package com.cnaps.services;

import com.cnaps.models.RefAccInfoTypMod;

public interface RefAccInfoTypService extends CRUDService<RefAccInfoTypMod> {
	RefAccInfoTypMod getByAbbrev(String abrev);
	RefAccInfoTypMod getById_type_info(int id_type_info);
}
