package com.cnaps.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnaps.models.TecMemoMod;

import com.cnaps.repository.TecMemoRepository;
@Service
public class TecMemoServiceImpl implements TecMemoService {
	@Autowired
	TecMemoRepository tecMemoRepository;
	@Override
	public void save(TecMemoMod entity) {
		tecMemoRepository.save(entity);
	}

	@Override
	public TecMemoMod getById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TecMemoMod> getAll(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(TecMemoMod entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public int nombrepage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TecMemoMod> getByIdIndividu(String idIndividu) {
		return tecMemoRepository.findByIdIndividu(idIndividu);
	}

}
