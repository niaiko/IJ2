package com.cnaps.services;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cnaps.models.TecEtatDossMod;
import com.cnaps.utils.DateUtil;

import com.cnaps.repository.TecEtatDossRepository;

@Service
public class TecEtatDossServiceImpl implements  TecEtatDossService{

	public static int max=50;
	
	
	
	@Autowired
	private TecEtatDossRepository tecEtatDossRepository;
	
	@Autowired
	TecEtatDossService service;

	@Override
	public void save(TecEtatDossMod entity) {
		tecEtatDossRepository.save(entity);
	}

	@Override
	public TecEtatDossMod getById(Serializable id) {
		return tecEtatDossRepository.findById((int)id).get();
	}

	@Override
	public List<TecEtatDossMod> getAll(int page) {
		Pageable pageable = PageRequest.of(page - 1, max);
		return (tecEtatDossRepository.findAll(pageable).getContent());
	}

	@Override
	public void delete(TecEtatDossMod a) {
		tecEtatDossRepository.delete(a);
	}
	
	@Override
	public int nombrepage() {
		return (int)(tecEtatDossRepository.count()/max)+1;
	}

	@Override
	public void updateEtatDemande(String idacc, int etat) {
		tecEtatDossRepository.updateEtatDemande(idacc, etat);
	}

	@Override
	public List<TecEtatDossMod> findByIdAcc(String idacc) {
		Pageable pageable = PageRequest.of(0, 1, Sort.Direction.DESC,"date_etat");
		return tecEtatDossRepository.findByIdAcc(idacc, pageable);
	}

	@Override
	public void updateNumOp(String numOp,Date date_etat,String idAcc) {
		tecEtatDossRepository.updateOp(numOp,date_etat,idAcc);
	}

	@Override
	public List<TecEtatDossMod> getAllWithOp() {
		return tecEtatDossRepository.findAllWithNumOp();
	}

	@Override
	public void updateOp(List<String> idAcc,String numOp) {
		for(int i=0;i<idAcc.size();i++) {
			List<TecEtatDossMod> verifTecEtatDoss = service.findByIdAcc(idAcc.get(i));
			if(verifTecEtatDoss.size() != 0) {
				if(verifTecEtatDoss.get(0).getId_op() == null) {
					verifTecEtatDoss.get(i).setId_op(numOp);
					verifTecEtatDoss.get(i).setDate_etat(DateUtil.sqlDateNow());
					service.save(verifTecEtatDoss.get(i));
				}
			}
		}
	}

}
