package com.cnaps.services;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.cnaps.models.AccueilMod;
import com.cnaps.models.DemandeIJMod;
import com.cnaps.models.RefAccInfoTypMod;
import com.cnaps.models.RefEnfantNeMod;
import com.cnaps.models.TecElemCalcMod;
import com.cnaps.models.TecInfoRecuMod;
import com.cnaps.models.TecMemoMod;
import com.cnaps.models.TecPcsRecMod;
import com.cnaps.models.param.DemandeFiltre;
import com.cnaps.utils.RequestApi;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.cnaps.models.ParametrePfMod;

@Service
public class DemandeIJServiceImpl implements DemandeIJService {
	String historique;
	static int TYPE_INFO_PRG = 52;
	private static final Logger LOG = LoggerFactory.getLogger(DemandeIJServiceImpl.class);
	@Autowired
	AccueilService accService;

	@Autowired
	TecInfoRecuService tecInfoService;

	@Autowired
	RefEtatTypService refEtatTypService;

	@Autowired
	TecEtatDossService tecEtatService;

	@Autowired
	TecPcsRecService tecPcsService;

	@Autowired
	TecHistoEtatService tecHistoService;

	@Autowired
	RefEnfantNeService refEnfantNeService;

	@Autowired
	RefRfaOrdService refRfaOrdService;

	@Autowired
	RefRfaOrdDetService refRfaOrdDetService;

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	TecMemoService tecMemoService;

	@Autowired
	ParametrePfService parametrePfService;

	@Autowired
	TecElemCalcService tecElemCalcService;

	@Autowired
	RefAccInfoTypService refAccInfoTypService;

	@Autowired
	RequestApi request;

	ObjectMapper om = new ObjectMapper();

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyy");

	@Override
	public void enregistrerDemande(DemandeIJMod demandeIJMod, int etat, String token) {
		try {
			LOG.info(om.writeValueAsString(demandeIJMod));
			String date = simpleDateFormat.format(new Date(Calendar.getInstance().getTime().getTime()));
			demandeIJMod.getAccueilMod().setDateInsertion(new Date(Calendar.getInstance().getTime().getTime()));
			demandeIJMod.getAccueilMod().setIdAccNew(date + String.format("%04d", accService.seqDemande()));
			demandeIJMod.getAccueilMod().setLast(true);
			demandeIJMod.getAccueilMod().setEtat(etat);
			demandeIJMod.getAccueilMod().setId_allocataire(demandeIJMod.getAccueilMod().getId_allocataire());
			
			//Ajout date prescription 1 an apres la date de dossier
			java.sql.Date daty = demandeIJMod.getAccueilMod().getDate_dossier();
			Calendar cal = GregorianCalendar.getInstance();
			cal.setTime(daty);
			cal.add(GregorianCalendar.MONTH, 12);
			java.sql.Date datyy = new java.sql.Date(cal.getTime().getTime());
			demandeIJMod.getAccueilMod().setDate_prescription(datyy);
			
			if (demandeIJMod.getAccueilMod().getId_tec_dmd().compareToIgnoreCase("400") == 0) {
				if (demandeIJMod.getModepaietiers() != null) {
					demandeIJMod.getModepaietiers().setIdAcc(demandeIJMod.getAccueilMod().getId_acc());
					request.sendPost("http://cnapsdbReglement:8529/ajouttrsmodepaie",
							om.writeValueAsString(demandeIJMod.getModepaietiers()), token.replace("Bearer ", ""));
					demandeIJMod.getAccueilMod().setId_mode_paiement_tiers(
							String.valueOf(demandeIJMod.getModepaietiers().getIdModePaiementTiers()));
				}
			}
			accService.save(demandeIJMod.getAccueilMod());
			for (int i = 0; i < demandeIJMod.getTecInfoRecuMod().size(); i++) {
				demandeIJMod.getTecInfoRecuMod().get(i).setIdAcc(demandeIJMod.getAccueilMod().getId_acc());
				LOG.info(om.writeValueAsString(demandeIJMod.getTecInfoRecuMod().get(i)));
				tecInfoService.save(demandeIJMod.getTecInfoRecuMod().get(i));

			}
			for (int j = 0; j < demandeIJMod.getTecPcsRecMod().size(); j++) {
				demandeIJMod.getTecPcsRecMod().get(j).setId_acc(demandeIJMod.getAccueilMod().getId_acc());
				demandeIJMod.getTecPcsRecMod().get(j).setNumpcs("0");
				tecPcsService.save(demandeIJMod.getTecPcsRecMod().get(j));
			}
			// if (demandeIJMod.getAccueilMod().getId_tec_dmd().compareTo("412") == 0 ||
			// demandeIJMod.getAccueilMod().getId_tec_dmd().compareTo("413") == 0) {//
			// demande AM1
			if (demandeIJMod.getRefEnfantNeMod().size() != 0) {
				for (int i = 0; i < demandeIJMod.getRefEnfantNeMod().size(); i++) {
					demandeIJMod.getRefEnfantNeMod().get(i).setId_acc(demandeIJMod.getAccueilMod().getId_acc());
					refEnfantNeService.save(demandeIJMod.getRefEnfantNeMod().get(i));
				}
				if (demandeIJMod.getAccueilMod().getId_tec_dmd().compareToIgnoreCase("414") == 0) {
					List<ParametrePfMod> liste = parametrePfService.getByParamPf(3);
					double droit = (6 * liste.get(0).getValeurs()) * demandeIJMod.getRefEnfantNeMod().size();
					TecElemCalcMod elem = new TecElemCalcMod();
					elem.setId_acc(demandeIJMod.getAccueilMod().getId_acc());
					elem.setValeur(String.valueOf(droit));
					elem.setId_element(tecElemCalcService.seqElemCalc());
					tecElemCalcService.save(elem);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public DemandeIJMod detailDemande(String id_acc) {
		DemandeIJMod data = new DemandeIJMod();
		List<TecMemoMod> listeMemo = new ArrayList<>();
		List<AccueilMod> listeHisto = new ArrayList<>();
		List<AccueilMod> accueilMod = accService.getByIdAcc(id_acc);
		if (accueilMod.size() != 0) {
			List<TecInfoRecuMod> tecInfoRecuMod = tecInfoService.findByIdAccueil(id_acc);
			if (tecInfoRecuMod.size() != 0) {
				for (int i = 0; i < tecInfoRecuMod.size(); i++) {
					RefAccInfoTypMod refAcc = refAccInfoTypService
							.getById_type_info(tecInfoRecuMod.get(i).getIdTypeInfo());
					if (refAcc != null)
						tecInfoRecuMod.get(i).setRefAccInfoTypMod(refAcc);
				}
				data.setTecInfoRecuMod(tecInfoRecuMod);
			}
			List<TecPcsRecMod> tecPcsRecMod = tecPcsService.findByIdAccueil(id_acc);
			if (tecPcsRecMod.size() != 0)
				data.setTecPcsRecMod(tecPcsRecMod);
			for (AccueilMod acc : accueilMod) {
				if (acc.getLast()) {
					/*
					 * RefEtatTypMod libelleEtat = refEtatTypService.getByIdTypeEtat(acc.getEtat());
					 * acc.setLibelle_etat(libelleEtat.getLibelle());
					 */
					data.setAccueilMod(acc);
					List<RefEnfantNeMod> refEnfantNeMod = refEnfantNeService.findByIdAccueil(id_acc);
					if (refEnfantNeMod.size() != 0)
						data.setRefEnfantNeMod(refEnfantNeMod);
					listeMemo = tecMemoService.getByIdIndividu(acc.getId_individu());
					if (listeMemo.size() != 0)
						data.setListeMemo(listeMemo);
				} else
					listeHisto.add(acc);
			}
			data.setHistoEtatDmd(listeHisto);
			List<TecElemCalcMod> elemCalc = tecElemCalcService.findByIdAcc(id_acc);
			if (elemCalc.size() != 0)
				data.setDroit(Double.parseDouble(elemCalc.get(0).getValeur()));
		}
		return data;
		/*
		 * List<TecHistoEtatMod> listeHisto = new ArrayList<>(); List<TecMemoMod>
		 * listeMemo = new ArrayList<>(); AccueilMod accueilMod =
		 * accService.getById(id_acc); List<TecInfoRecuMod> tecInfoRecuMod =
		 * tecInfoService.findByIdAccueil(id_acc); List<TecPcsRecMod> tecPcsRecMod =
		 * tecPcsService.findByIdAccueil(id_acc); data.setAccueilMod(accueilMod);
		 * data.setTecInfoRecuMod(tecInfoRecuMod); data.setTecPcsRecMod(tecPcsRecMod);
		 * listeHisto = tecHistoService.findDemandeStatusByidacc(id_acc);
		 * if(listeHisto.size() != 0) { for(int i=0;i<listeHisto.size();i++) {
		 * RefEtatTypMod libelleEtat =
		 * refEtatTypService.getByIdTypeEtat(listeHisto.get(i).getId_type_etat());
		 * if(libelleEtat != null)
		 * listeHisto.get(i).setLibelle(libelleEtat.getLibelle()); }
		 * data.setHistoEtatDmd(listeHisto); }
		 * if(accueilMod.getId_tec_dmd().compareTo("412") == 0 ||
		 * accueilMod.getId_tec_dmd().compareTo("413") == 0 ) { List<RefEnfantNeMod>
		 * refEnfantNeMod = refEnfantNeService.findByIdAccueil(id_acc);
		 * if(refEnfantNeMod.size() !=0) { data.setRefEnfantNeMod(refEnfantNeMod); }else
		 * { refEnfantNeMod = new ArrayList<>(); data.setRefEnfantNeMod(refEnfantNeMod);
		 * }
		 * 
		 * } listeMemo = tecMemoService.getByIdIndividu(accueilMod.getId_individu());
		 * if(listeMemo.size() != 0) data.setListeMemo(listeMemo);
		 */
	}

	/*
	 * @Override public DemandeIJMod detailRfa(ParamRfaMod param) { DemandeIJMod
	 * data = new DemandeIJMod(); AccueilMod accueilMod =
	 * accService.getById(param.getId_acc()); List<TecInfoRecuMod> tecInfoRecuMod =
	 * tecInfoService.findByIdAccueil(param.getId_acc()); List<TecPcsRecMod>
	 * tecPcsRecMod = tecPcsService.findByIdAccueil(param.getId_acc());
	 * List<TecHistoEtatMod> listeEtat =
	 * tecHistoService.findDemandeStatusByidacc(param.getId_acc());
	 * if(listeEtat.size() == 0) { listeEtat = new ArrayList<>(); }
	 * data.setHistoEtatDmd(listeEtat); data.setAccueilMod(accueilMod);
	 * data.setTecInfoRecuMod(tecInfoRecuMod); data.setTecPcsRecMod(tecPcsRecMod);
	 * List<RefEnfantNeMod> listeEnfant =
	 * refEnfantNeService.findByIdAccueil(param.getId_acc()); if(listeEnfant.size()
	 * != 0) { data.setRefEnfantNeMod(listeEnfant); }else { listeEnfant = new
	 * ArrayList<>(); data.setRefEnfantNeMod(listeEnfant); } //OrdonnanceMod
	 * ordonnance = new OrdonnanceMod();
	 * //ordonnance.setOrdMere(refRfaOrdService.findByIdAccueil(param.getId_acc()));
	 * //ordonnance.setOrdFille(refRfaOrdDetService.findByIdOrdMere(ordonnance.
	 * getOrdMere().getId_ref_rfa_ord(), //param.isValidationPF()));
	 * //data.setOrdonnanceMod(ordonnance); return data; }
	 * 
	 * public void enregistrerOrdonnance(OrdonnanceMod ordonnance, Session s) {
	 * s.save(ordonnance.getOrdMere()); LOG.info("id ordonnance mere" +
	 * ordonnance.getOrdMere().getId_ref_rfa_ord()); int size =
	 * ordonnance.getOrdFille().size(); for (int i = 0; i < size; i++) {
	 * ordonnance.getOrdFille().get(i).setId_ref_rfa_ord(ordonnance.getOrdMere().
	 * getId_ref_rfa_ord()); LOG.info("id ordonnance fille" +
	 * ordonnance.getOrdFille().get(i).getId_ref_ord_det());
	 * s.save(ordonnance.getOrdFille().get(i)); } //
	 * refRfaOrdDetService.save(ordonnance.getOrdFille()); }
	 */

	@Override
	public boolean prolongationIJ2(DemandeIJMod demandeIJMod) {
		boolean rep = false;
		for (int i = 0; i < demandeIJMod.getTecInfoRecuMod().size(); i++) {
			if (demandeIJMod.getTecInfoRecuMod().get(i).getIdTypeInfo() == TYPE_INFO_PRG) {
				int valeur = Integer.parseInt(demandeIJMod.getTecInfoRecuMod().get(i).getValeur());
				if (valeur > 0) {
					rep = true;
					break;
				}
			}
		}
		return rep;
	}

	@Override
	public Map<String, Object> listeRFA(DemandeFiltre param) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		Page<AccueilMod> liste = accService.getByIdIndividuAndIdAccAndDateReceptionAndIdTecDmd(param);
		if (liste.getContent().size() != 0) {
			for (AccueilMod acc : liste) {

			}
		}
		return map;
	}

}
