package com.cnaps.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnaps.models.TecInfoRecuTraitMod;

import com.cnaps.repository.TecInfoRecuTraitRepository;
@Service
public class TecInfoRecuTraitServiceImpl implements TecInfoRecuTraitService {
	
	@Autowired
	TecInfoRecuTraitRepository tecInfoRecuTraitRepository;
	@Override
	public void save(TecInfoRecuTraitMod entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public TecInfoRecuTraitMod getById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TecInfoRecuTraitMod> getAll(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(TecInfoRecuTraitMod entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public int nombrepage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TecInfoRecuTraitMod> findByIdAccueil(String id_acc) {
		// TODO Auto-generated method stub
		return tecInfoRecuTraitRepository.findByIdAccueil(id_acc);
	}

}
