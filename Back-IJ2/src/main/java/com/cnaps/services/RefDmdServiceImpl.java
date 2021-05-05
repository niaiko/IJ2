package com.cnaps.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnaps.models.RefDmdMod;
import com.cnaps.repository.refDmdRepository;


@Service
public class RefDmdServiceImpl implements  RefDmdService{

	public static int max=10;
	
	@Autowired
	private refDmdRepository RefdmdRepository;

	@Override
	public void save(RefDmdMod entity) {
		// TODO Auto-generated method stub
		RefdmdRepository.save(entity);
	}

	@Override
	public RefDmdMod getById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RefDmdMod> getAll(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(RefDmdMod entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int nombrepage() {
		// TODO Auto-generated method stub
		return 0;
	}

}
