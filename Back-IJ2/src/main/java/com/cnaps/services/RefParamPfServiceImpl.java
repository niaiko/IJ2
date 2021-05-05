package com.cnaps.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cnaps.models.RefParamPfMod;
import com.cnaps.repository.RefParamPfRepository;


@Service
public class RefParamPfServiceImpl implements  RefParamPfService{

	public static int max=50;
	
	@Autowired
	private  RefParamPfRepository refParamPfRepository;

	@Override
	public void save(RefParamPfMod entity) {
		refParamPfRepository.save(entity);
	}

	@Override
	public RefParamPfMod getById(Serializable id) {
		return refParamPfRepository.findById((int)id).get();
			
	}

	@Override
	public List<RefParamPfMod> getAll(int page) {
		Pageable pageable = PageRequest.of(page - 1, max);
		return (refParamPfRepository.findAll(pageable).getContent());
	}

	@Override
	public void delete(RefParamPfMod a) {
		refParamPfRepository.delete(a);
	}
	
	@Override
	public int nombrepage() {
		return (int)(refParamPfRepository.count()/max)+1;
	}

	
}
