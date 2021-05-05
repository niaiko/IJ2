package com.cnaps.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cnaps.models.TecInfoRecuMod;
import com.cnaps.repository.TecInfoRecuRepository;

@Service
public class TecInfoRecuServiceImpl implements  TecInfoRecuService{

	public static int max=50;
	
	@Autowired
	private TecInfoRecuRepository tecInfoRecuRepository;

	@Override
	public void save(TecInfoRecuMod entity) {
		tecInfoRecuRepository.save(entity);
	}

	@Override
	public TecInfoRecuMod getById(Serializable id) {
		return null;
	}

	@Override
	public List<TecInfoRecuMod> getAll(int page) {
		Pageable pageable = PageRequest.of(page -1, max);
		return (tecInfoRecuRepository.findAll(pageable).getContent());
	}

	@Override
	public void delete(TecInfoRecuMod a) {
		tecInfoRecuRepository.delete(a);
	}
	
	@Override
	public int nombrepage() {
		return (int)(tecInfoRecuRepository.count()/max)+1;
	}

	@Override
	public List<TecInfoRecuMod> findByIdAccueil(String id_acc) {
		return tecInfoRecuRepository.findByIdAccueil(id_acc);
	}

	@Override
	public void save(List<TecInfoRecuMod> tecInfoRecuList) {
		tecInfoRecuRepository.saveAll(tecInfoRecuList);	
	}

	@Override
	public long seqTecInfoRecu() {
		return tecInfoRecuRepository.seqTecInfoRecu();
	}

	@Override
	public TecInfoRecuMod getByIdAccIsAndIdTypeInfoIs(String idAcc, Integer idTypeInfo) {
		// TODO Auto-generated method stub
		return tecInfoRecuRepository.findByIdAccIsAndIdTypeInfoIs(idAcc, idTypeInfo);
	}

}
