package com.cnaps.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cnaps.models.TecInfoReqMod;
import com.cnaps.models.TecInfoReqPK;
import com.cnaps.repository.TecInfoReqRepository;

@Service
public class TecInfoReqServiceImpl implements  TecInfoReqService{

	public static int max=50;
	
	@Autowired
	private TecInfoReqRepository tecInfoReqRepository;

	@Override
	public void save(TecInfoReqMod entity) {
		tecInfoReqRepository.save(entity);
	}

	@Override
	public TecInfoReqMod getById(Serializable id) {
		return tecInfoReqRepository.findById((TecInfoReqPK)id).get();
	}

	@Override
	public List<TecInfoReqMod> getAll(int page) {
		Pageable pageable = PageRequest.of(page - 1, max);
		return (tecInfoReqRepository.findAll(pageable).getContent());
	}

	@Override
	public void delete(TecInfoReqMod a) {
		tecInfoReqRepository.delete(a);
	}
	
	@Override
	public int nombrepage() {
		return (int)(tecInfoReqRepository.count()/max)+1;
	}

}
