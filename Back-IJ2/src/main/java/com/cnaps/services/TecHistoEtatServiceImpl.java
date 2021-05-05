package com.cnaps.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnaps.models.TecHistoEtatMod;

import com.cnaps.repository.TecHistoEtatRepository;

@Service
public class TecHistoEtatServiceImpl implements TecHistoEtatService{

	public static int max=10;

	@Autowired
	private TecHistoEtatRepository techistoEtat;

	
	@Override
	public void save(TecHistoEtatMod entity) {
		// TODO Auto-generated method stub
		techistoEtat.save(entity);
	}

	@Override
	public TecHistoEtatMod getById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TecHistoEtatMod> getAll(int page) {
		// TODO Auto-generated method stub
		return techistoEtat.findAll();
	}

	@Override
	public void delete(TecHistoEtatMod entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int nombrepage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TecHistoEtatMod> findDemandeStatusByidacc(String idacc) {
		// TODO Auto-generated method stub
		return techistoEtat.findByidacc(idacc);
	}
	
	

}
