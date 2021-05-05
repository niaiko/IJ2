package com.cnaps.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cnaps.models.DemandeMod;
import com.cnaps.models.param.DemandeFiltre;
import com.cnaps.models.param.DemandeParam;
import com.cnaps.repository.DemandeRepository;


@Service
public class DemandeServiceImpl implements  DemandeService{

	public static int max=10;
	
	@Autowired
	private DemandeRepository demandeRepository;

	@Override
	public DemandeMod getById(Serializable id) {
		return demandeRepository.getOne((String) id);
	}

	@Override
	public List<DemandeMod> getAll(int page) {
		Pageable pageable = PageRequest.of(page -1, max);
		return (demandeRepository.findAll(pageable).getContent());
	}

	@Override
	public void delete(DemandeMod entity) {
		demandeRepository.delete(entity);
		
	}

	@Override
	public int nombrepage() {
		return (int)(demandeRepository.count()/max)+1;
	}

	@Override
	public void save(DemandeMod acc) {
		demandeRepository.save(acc);
	}

	@Override
	public List<DemandeMod> advancedSearchDemande(DemandeMod dem) {
		return demandeRepository.advancedSearchDemande(dem);
	}

	@Override
	public Page<DemandeMod> listeAvecParam(int param, String prestation,int page) {
		Pageable pageable = PageRequest.of(page-1,max,Sort.Direction.DESC,"date_reception");
		return demandeRepository.listeAvecParam(param,prestation,pageable);
	}

	@Override
	public int nombreDePageParEtat(int etat, String prestation) {
		return (int)(demandeRepository.nombreDePageParEtat(etat,prestation)/max)+1;
	}

	@Override
	public List<DemandeMod> HistoDemandeById(DemandeMod dem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DemandeMod FindDemandeByMatriculeAndPrestation(DemandeMod dem) {
		// TODO Auto-generated method stub
		return demandeRepository.DemandeValide(dem.getEtat(), dem.getReference(), dem.getMatricule());
	}

	@Override
	public List<DemandeMod> getSearchAdvancedNoDate(DemandeMod dem, int page) {
		Pageable pageable = PageRequest.of(page-1,max,Sort.Direction.DESC,"date_reception");
		return demandeRepository.searchAvancedNoDate(dem, pageable);
	}

	@Override
	public List<DemandeMod> getSearchAdvanced(DemandeMod dem, int page) {
		Pageable pageable = PageRequest.of(page-1,max,Sort.Direction.DESC,"date_reception");
		return demandeRepository.searchAvanced(dem, pageable); 
	}

	@Override
	public List<DemandeMod> getSearchAll(int page) {
		Pageable pageable = PageRequest.of(page-1,max,Sort.Direction.DESC,"date_reception");
		return demandeRepository.searchAll(pageable);
	}

	@Override
	public List<DemandeMod> getByMatricule(String matricule) {
		return demandeRepository.findByMatricule(matricule);
	}

	@Override
	public DemandeMod getByReference(String reference) {
		return demandeRepository.findByReference(reference);
	}

	@Override
	public List<DemandeMod> getAllDmd(DemandeParam dem, int page) {
		Pageable pageable = PageRequest.of(dem.getPagination()-1,max,Sort.Direction.DESC,"date_reception");
		return demandeRepository.findAllDmd(dem, pageable);
	}

	@Override
	public Page<DemandeMod> getByIdIndividuAndIdAccAndDateReceptionAndIdTecDmd(DemandeFiltre dem) {
		Pageable pageable = PageRequest.of(dem.getPagination()-1,dem.getTaille(),Sort.Direction.DESC,"date_reception");
		return demandeRepository.findByIdIndividuAndIdAccAndDateReceptionAndIdTecDmd(dem, pageable);
	}

	@Override
	public List<DemandeMod> getAllDmdEnfant(DemandeParam dem) {
		Pageable pageable = PageRequest.of(dem.getPagination()-1,max,Sort.Direction.DESC,"date_reception");
		return demandeRepository.findAllDmdEnfant(dem, pageable);
	}


}
