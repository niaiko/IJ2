package com.cnaps.services;
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cnaps.models.RefEnfantNeMod;
import com.cnaps.repository.RefEnfantNeRepository;


@Service
public class RefEnfantNeServiceImpl implements  RefEnfantNeService{

	public static int max=50;
	
	@Autowired
	private  RefEnfantNeRepository refEnfantNeRepository;

	@Override
	public void save(RefEnfantNeMod entity) {
		refEnfantNeRepository.save(entity);
	}

	@Override
	public RefEnfantNeMod getById(Serializable id) {
		return refEnfantNeRepository.findById((int)id).get();

	}

	@Override
	public List<RefEnfantNeMod> getAll(int page) {
		Pageable pageable = PageRequest.of(page - 1, max);
		return (refEnfantNeRepository.findAll(pageable).getContent());
	}

	@Override
	public void delete(RefEnfantNeMod a) {
		refEnfantNeRepository.delete(a);
	}
	
	@Override
	public int nombrepage() {
		return (int)(refEnfantNeRepository.count()/max)+1;
	}

	@Override
	public void save(List<RefEnfantNeMod> listRefEnfantNeMod) {
		refEnfantNeRepository.saveAll(listRefEnfantNeMod);
	}

	@Override
	public List<RefEnfantNeMod> findByIdAccueil(String id_acc) {
		return refEnfantNeRepository.findByIdAccueil(id_acc);
	}

	@Override
	public List<RefEnfantNeMod> getByIdAccIsAndMatriculeIs(String idAcc, String matricule) {
		return refEnfantNeRepository.findByIdAccIsAndMatriculeIs(idAcc, matricule);
	}

	
}
