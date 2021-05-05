package com.cnaps.services;

import java.util.List;

import com.cnaps.models.TecMemoMod;

public interface TecMemoService extends CRUDService<TecMemoMod> {
	List<TecMemoMod> getByIdIndividu(String idIndividu);
}
