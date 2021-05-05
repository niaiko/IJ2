package com.cnaps.services;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cnaps.models.AccueilMod;
import com.cnaps.models.TecEtatDossMod;
import com.cnaps.models.TecHistoEtatMod;
import com.cnaps.models.enfant.AccueilEnfantMod;
import com.cnaps.models.param.DemandeFiltre;
import com.cnaps.repository.AccueilRepository;
import com.cnaps.repository.ListeDmdPfRepository;

@Service
public class AccueilServiceImpl implements AccueilService {

	public static int max = 50;

	@Autowired
	TecEtatDossService etatDossService;

	@Autowired
	TecHistoEtatService tecHistoEtatService;

	@Autowired
	private AccueilRepository accueilRepository;

	@Autowired
	ListeDmdPfRepository listeDmdRepository;

	@Override
	public AccueilMod getById(Serializable id) {
		return accueilRepository.findById((String) id).get();	
		}

	@Override
	public List<AccueilMod> getAll(int page) {
		Pageable pageable = PageRequest.of(page -1, max);
		return (accueilRepository.findAll(pageable).getContent());
	}

	@Override
	public void delete(AccueilMod entity) {
		accueilRepository.delete(entity);

	}

	@Override
	public int nombrepage() {
		return (int) (accueilRepository.count() / max) + 1;
	}

	@Override
	public void save(AccueilMod acc) {
		accueilRepository.save(acc);
	}

	@Override
	public long seqDemande() {
		return accueilRepository.seqDemande();
	}

	@Override
	public List<AccueilMod> listeAvecParam(int param) {
		return accueilRepository.listeAvecParam(param);
	}

	@Override
	public List<AccueilMod> getbyidacc(String idacc) {
		Pageable pageable = PageRequest.of(0, 1, Sort.Direction.DESC, "date_dossier");
		return accueilRepository.getbyidacc(idacc, pageable);
	}

	@Override
	public List<AccueilMod> getbyidIndiv(String id_individu) {
		Pageable pageable = PageRequest.of(0, 1, Sort.Direction.DESC, "date_dossier");
		return accueilRepository.getbyidIndiv(id_individu, pageable);
	}

	@Override
	public List<AccueilMod> getbyidIndivAndPrestation(String id_individu, String prestation) {
		Pageable pageable = PageRequest.of(0, 1, Sort.Direction.DESC, "date_dossier");
		return accueilRepository.getbyidIndivAndPrestation(id_individu, prestation,
				pageable);
	}

	@Override
	public List<AccueilMod> getByIdAcc(String idAcc) {
		return accueilRepository.findByIdAcc(idAcc);
	}

	@Override
	public void updateEmpl(String idEmpl, String id_succursale, String idAcc) {
		accueilRepository.updateEmpl(idEmpl, id_succursale, idAcc);

	}

	@Override
	public AccueilMod saveEnfant(AccueilEnfantMod enfant) {
		AccueilMod acc = new AccueilMod();
		acc.setId_acc(enfant.getIdAcc());
		acc.setId_tec_dmd("461");
		acc.setDate_dossier(enfant.getDateDossier());
		acc.setDate_modif(enfant.getDateModif());
		acc.setDateInsertion(new Date(Calendar.getInstance().getTime().getTime()));
		acc.setId_empl(enfant.getIdEmpl());
		acc.setId_individu(enfant.getIdIndividu());
		acc.setId_succursale(enfant.getIdSuccursale());
		acc.setNum_doss(enfant.getNumDoss());
		acc.setUser_insert(enfant.getUserInsert());
		acc.setUser_modif(enfant.getUserModif());
		accueilRepository.save(acc);

		TecEtatDossMod etat = new TecEtatDossMod();
		etat.setId_acc(acc.getId_acc());
		etat.setId_type_etat(1);
		etat.setDate_etat(new Date(Calendar.getInstance().getTime().getTime()));
		etatDossService.save(etat);

		TecHistoEtatMod histo = new TecHistoEtatMod();
		histo.setIdacc(acc.getId_acc());
		histo.setId_type_etat(1);
		histo.setDateetat(new Date(Calendar.getInstance().getTime().getTime()));
		tecHistoEtatService.save(histo);

		return acc;
	}

	@Override
	public List<AccueilMod> getByIdIndividuIsAndIdTecDmdIs(String idAcc, String idTecDmd) {
		return accueilRepository.findByIdIndividuIsAndIdTecDmdIs(idAcc, idTecDmd);
	}

	@Override
	public Page<AccueilMod> getByIdIndividuAndIdAccAndDateReceptionAndIdTecDmd(DemandeFiltre dem) {
		Pageable pageable = PageRequest.of(dem.getPagination() -1, dem.getTaille());
		// TODO Auto-generated method stub
		return accueilRepository.findByIdIndividuAndIdAccAndDateReceptionAndIdTecDmd(dem,
				pageable);
	}

	@Override
	public AccueilMod getByIdAccIsAndLast(String idAcc) {
		// TODO Auto-generated method stub
		return accueilRepository.findByIdAccIsAndLast(idAcc);
	}

	@Override
	public List<AccueilMod> getByIdIndividuAndLast(String idIndividu) {
		// TODO Auto-generated method stub
		return accueilRepository.findByIdIndividuAndLast(idIndividu);
	}

	@Override
	public List<AccueilMod> getByidIndivuAndPrestation(String idIndividu, String prestation) {
		// TODO Auto-generated method stub
		return accueilRepository.findByidIndivuAndPrestation(idIndividu, prestation);
	}

	@Override
	public long seqAccNews() {
		// TODO Auto-generated method stub
		return accueilRepository.seqAccNews();
	}


}
