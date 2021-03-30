package com.cnaps.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cnaps.models.RefRfaOrdMod;
import com.cnaps.repository.RefRfaOrdRepository;


@Service
public class RefRfaOrdServiceImpl implements  RefRfaOrdService{

	public static int max=50;
	
	@Autowired
	private  RefRfaOrdRepository refRfaOrdRepository;

	@Override
	public void save(RefRfaOrdMod entity) {
		refRfaOrdRepository.save(entity);
	}

	@Override
	public  RefRfaOrdMod getById(Serializable id) {
		return refRfaOrdRepository.findById((int)id).get();
	}

	@Override
	public List<RefRfaOrdMod> getAll(int page) {
		Pageable pageable = PageRequest.of(page - 1, max);
		return (refRfaOrdRepository.findAll(pageable).getContent());
	}

	@Override
	public void delete(RefRfaOrdMod a) {
		refRfaOrdRepository.delete(a);
	}
	
	@Override
	public int nombrepage() {
		return (int)(refRfaOrdRepository.count()/max)+1;
	}

	@Override
	public RefRfaOrdMod findByIdAccueil(String id_acc) {
		return refRfaOrdRepository.findByIdAccueil(id_acc);
	}

	
}
