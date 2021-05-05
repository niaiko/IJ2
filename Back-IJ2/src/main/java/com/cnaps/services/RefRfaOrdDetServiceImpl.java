package com.cnaps.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cnaps.models.RefRfaOrdDetMod;
import com.cnaps.repository.RefRfaOrdDetRepository;


@Service
public class RefRfaOrdDetServiceImpl implements  RefRfaOrdDetService{

	public static int max=50;
	
	@Autowired
	private  RefRfaOrdDetRepository refRfaOrdDetRepository;

	@Override
	public void save(RefRfaOrdDetMod entity) {
		refRfaOrdDetRepository.save(entity);
	}

	@Override
	public  RefRfaOrdDetMod getById(Serializable id) {
		return refRfaOrdDetRepository.findById((int)id).get();
	}

	@Override
	public List<RefRfaOrdDetMod> getAll(int page) {
		Pageable pageable = PageRequest.of(page - 1, max);
		return (refRfaOrdDetRepository.findAll(pageable).getContent());
	}

	@Override
	public void delete(RefRfaOrdDetMod a) {
		refRfaOrdDetRepository.delete(a);
	}
	
	@Override
	public int nombrepage() {
		return (int)(refRfaOrdDetRepository.count()/max)+1;
	}

	@Override
	public void save(List<RefRfaOrdDetMod> listRefRfaOrdDetMod) {
		refRfaOrdDetRepository.saveAll(listRefRfaOrdDetMod);
		
	}

	@Override
	public List<RefRfaOrdDetMod> findByIdOrdMere(int id_mere) {
		return refRfaOrdDetRepository.findByIdOrdMere(id_mere);
	}

	@Override
	public List<RefRfaOrdDetMod> findByIdOrdMere(int id_mere, boolean service) {
		return refRfaOrdDetRepository.findByIdOrdMere(id_mere, service);
	}

	
}
