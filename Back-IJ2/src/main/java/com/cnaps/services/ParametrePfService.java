package com.cnaps.services;

import java.util.List;

import com.cnaps.models.ParametrePfMod;

public interface ParametrePfService extends CRUDService<ParametrePfMod> {
	List<ParametrePfMod> getByParamPf(int param_pf);
}
