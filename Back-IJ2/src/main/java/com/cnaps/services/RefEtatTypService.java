package com.cnaps.services;

import com.cnaps.models.RefEtatTypMod;

public interface RefEtatTypService extends CRUDService<RefEtatTypMod> {
	RefEtatTypMod getByIdTypeEtat(Integer idTypeEtat);
}
