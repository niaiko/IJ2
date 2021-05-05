package com.cnaps.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cnaps.models.RefTecDmdMod;
import com.cnaps.repository.RefTecDmdRepository;

@Service
public class RefTecDmdServiceImpl implements  RefTecDmdService{

public static int max=50;
	
	@Autowired
	private RefTecDmdRepository refTecDmdRepository;

	@Override
	public RefTecDmdMod getById(Serializable id) {
		return refTecDmdRepository.findById((String) id).get();	
		}

	@Override
	public List<RefTecDmdMod> getAll(int page) {
		Pageable pageable = PageRequest.of(page - 1, max);
		return (refTecDmdRepository.findAll(pageable).getContent());
	}

	@Override
	public void delete(RefTecDmdMod entity) {
		refTecDmdRepository.delete(entity);
		
	}

	@Override
	public int nombrepage() {
		return (int)(refTecDmdRepository.count()/max)+1;
	}

	@Override
	public void save(RefTecDmdMod acc) {
		refTecDmdRepository.save(acc);
	}

	@Override
	public RefTecDmdMod getById_tec_dmd(String id_tec_dmd) {
		return refTecDmdRepository.findById_tec_dmd(id_tec_dmd);
	}

	@Override
	public List<RefTecDmdMod> getAllPrestationPF(String prestation) {
		return refTecDmdRepository.findAllPrestationPF(prestation);
	}
}
