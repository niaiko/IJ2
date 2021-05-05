package com.cnaps.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.cnaps.models.AccueilMod;
import com.cnaps.models.param.DemandeFiltre;

public interface AccueilRepository extends JpaRepository<AccueilMod, String> {
	/*
	 * @Query(value = "select nextval('\"RFM\".seqdemande')", nativeQuery=true) long
	 * seqDemande();
	 */

	@Query(value = "select nextval('\"RFM\".seq_acc_new')", nativeQuery = true)
	long seqDemande();

	@Query(value = "select nextval('\"RFM\".seq_acc_news')", nativeQuery = true)
	long seqAccNews();

//	@Query(value="select u from AccueilMod u where u.tecEtatDoss.id_type_etat=?1")
	@Query(value = "select u from AccueilMod u where 1=?1")
	List<AccueilMod> listeAvecParam(int etat);

	@Query("select u from AccueilMod u where u.id_acc = ?1")
	List<AccueilMod> getbyidacc(String idacc, Pageable page);

	@Query("select u from AccueilMod u where u.id_individu = ?1 and etat = 3")
	List<AccueilMod> prendListidIndiv(String id_individu);

	@Query("select u from AccueilMod u where u.id_individu = ?1")
	List<AccueilMod> getbyidIndiv(String id_individu, Pageable page);

	@Query("select u from AccueilMod u where u.id_individu = ?1 and u.id_tec_dmd=?2")
	List<AccueilMod> getbyidIndivAndPrestation(String id_individu, String prestation, Pageable page);
	
	@Query(value = "SELECT * FROM \"RFM\".acc_new\r\n WHERE id_individu = ?1 and id_tec_dmd = ?2 ORDER BY date_insertion DESC limit 1", nativeQuery = true)
	public List<AccueilMod> findByIdIndividuWithPrestation(String idIndividu, String prestation);

	@Query("select u from AccueilMod u where u.id_acc = ?1 order by u.dateInsertion desc")
	List<AccueilMod> findByIdAcc(String idAcc);

	@Transactional
	@Modifying
	@Query(value = "UPDATE AccueilMod SET id_empl = ?1,id_succursale =?2 WHERE id_acc=?3 ")
	void updateEmpl(String idEmpl, String id_succursale, String idAcc);

	@Query(value = "select u from AccueilMod u where u.id_individu=?1 and u.id_tec_dmd=?2")
	List<AccueilMod> findByIdIndividuIsAndIdTecDmdIs(String idIndividu, String idTecDmd);

	@Query(value = "select u from AccueilMod u where u.last = true and "
			+ "(u.etat=:#{#dem.type_etat} or coalesce(:#{#dem.type_etat},null) is null or :#{#dem.type_etat} = 0) and "
			+ "(u.id_acc = :#{#dem.reference} or :#{#dem.reference} is null or :#{#dem.reference}='') and "
			+ "(u.dateInsertion=:#{#dem.dateReception} or coalesce(:#{#dem.dateReception},null) is null) and "
			+ "(u.id_individu=:#{#dem.matricule} or :#{#dem.matricule} is null or :#{#dem.matricule}='') and "
			+ "(u.id_tec_dmd=:#{#dem.prestation} or :#{#dem.prestation} is null) order by u.dateInsertion desc, u.id_acc desc")
	Page<AccueilMod> findByIdIndividuAndIdAccAndDateReceptionAndIdTecDmd(@Param("dem") DemandeFiltre dem,
			Pageable page);

	@Query(value = "select u from AccueilMod u where u.last = true and "
			+ "(u.etat=?1 or coalesce(u.etat) is null or coalesce(u.etat) = 0) and "
			+ "(u.id_acc = ?2 or u.id_acc is null or u.id_acc ='') and "
			+ "(u.dateInsertion=?3 or coalesce(u.dateInsertion) is null) and "
			+ "(u.id_individu=?4 or u.id_individu is null or u.id_individu ='') and "
			+ "(u.id_tec_dmd=?5 or u.id_tec_dmd is null)")
	List<AccueilMod> searchAvancerByIdIndividuAndIdAccAndDateReceptionAndIdTecDmd(int etat, String idAcc,
			Date dateInsert, String idIndividu, String idTecDmd, Pageable page);

//	@Query(value = "select distinct \r\n" + 
//			"	t1.id_acc, \r\n" + 
//			"	t1.id_tec_dmd, \r\n" + 
//			"	t1.date_dossier, \r\n" + 
//			"	t1.id_individu, \r\n" + 
//			"	t1.id_succursale, \r\n" + 
//			"	t1.id_empl, \r\n" + 
//			"	t1.num_doss, \r\n" + 
//			"	t1.date_insertion, \r\n" + 
//			"	t1.user_insert, \r\n" + 
//			"	t1.user_modif, \r\n" + 
//			"	t1.date_modif, \r\n" + 
//			"	t1.id_mode_paiement_tiers, \r\n" + 
//			"	t1.type, \r\n" + 
//			"	t1.last, \r\n" + 
//			"	t1.etat, \r\n" + 
//			"	t2.nom, \r\n" + 
//			"	t2.prenoms \r\n" + 
//			"from \"RFM\".acc_new t1 inner join \"RFM\".individu t2  \r\n" + 
//			"on t1.id_individu = t2.id_individu\r\n" + 
//			"where "
//			+ "t1.last = true and "
//			+ "(t1.etat=:#{#dem.type_etat} or coalesce(:#{#dem.type_etat},null) is null or :#{#dem.type_etat} = 0) and"
//			+ "(t1.id_acc = :#{#dem.reference} or :#{#dem.reference} is null or :#{#dem.reference}='') and"
//			+ "(t1.id_tec_dmd = :#{#dem.prestation} or :#{#dem.prestation} is null or :#{#dem.prestation}='') and"
////			+ "(t1.date_insertion=:#{#dem.dateReception} or coalesce(:#{#dem.dateReception},null) is null) and"
//			+ "(t1.id_individu=:#{#dem.matricule} or :#{#dem.matricule} is null or :#{#dem.matricule}='') and"
//			+ "(t2.nom=:#{#dem.nom} or :#{#dem.nom} is null or :#{#dem.nom}='') and"
//			+ "(t2.prenoms=:#{#dem.prenom} or :#{#dem.prenom} is null or :#{#dem.prenom}='')"
//			+ "order by t1.date_insertion desc "
//			+ "OFFSET :#{#dem.pagination} LIMIT 20", nativeQuery = true)
//	List<Object> searchByNomAndPrenom(@Param("dem") DemandeFiltre dem);

	@Query(value = "select distinct \r\n" + "	t1.id_acc, \r\n" + "	t1.id_tec_dmd, \r\n"
			+ "	t1.date_dossier, \r\n" + "	t1.id_individu, \r\n" + "	t1.id_succursale, \r\n" + "	t1.id_empl, \r\n"
			+ "	t1.num_doss, \r\n" + "	t1.date_insertion, \r\n" + "	t1.user_insert, \r\n" + "	t1.user_modif, \r\n"
			+ "	t1.date_modif, \r\n" + "	t1.id_mode_paiement_tiers, \r\n" + "	t1.type, \r\n" + "	t1.last, \r\n"
			+ "	t1.etat, \r\n" + "	t2.nom, \r\n" + "	t2.prenoms \r\n"
			+ "from \"RFM\".acc_new t1 inner join \"RFM\".individu t2  \r\n" + "on t1.id_individu = t2.id_individu\r\n"
			+ "where " + "t1.last = true and "
			+ "(t1.etat=:#{#dem.type_etat} or coalesce(:#{#dem.type_etat},null) is null or :#{#dem.type_etat} = 0) and"
			+ "(t2.nom=:#{#dem.nom} or :#{#dem.nom} is null or :#{#dem.nom}='') and"
			+ "(t2.prenoms=:#{#dem.prenom} or :#{#dem.prenom} is null or :#{#dem.prenom}='')"
			+ "order by t1.date_insertion desc " + "OFFSET :#{#dem.pagination} LIMIT 20", nativeQuery = true)
	List<Object> searchByNomAndPrenom(@Param("dem") DemandeFiltre dem);

	@Query(value = "select distinct \r\n" + "	t1.id_acc, \r\n" + "	t1.id_tec_dmd, \r\n"
			+ "	t1.date_dossier, \r\n" + "	t1.id_individu, \r\n" + "	t1.id_succursale, \r\n" + "	t1.id_empl, \r\n"
			+ "	t1.num_doss, \r\n" + "	t1.date_insertion, \r\n" + "	t1.user_insert, \r\n" + "	t1.user_modif, \r\n"
			+ "	t1.date_modif, \r\n" + "	t1.id_mode_paiement_tiers, \r\n" + "	t1.type, \r\n" + "	t1.last, \r\n"
			+ "	t1.etat, \r\n" + "	t2.nom, \r\n" + "	t2.prenoms \r\n"
			+ "from \"RFM\".acc_new t1 inner join \"RFM\".individu t2  \r\n" + "on t1.id_individu = t2.id_individu\r\n"
			+ "where " + "t1.last = true and " + "(t2.nom = ?1 or t2.prenoms = ?2)" + "order by t1.date_insertion desc "
			+ "OFFSET ?3 LIMIT 20", nativeQuery = true)
	List<Object> searchByNomAndPrenom(String nom, String prenoms, int page);

	@Query(value = "select \r\n" + "	(count(*)/20)+1\r\n"
			+ "from \"RFM\".acc_new t1 inner join \"RFM\".individu t2  \r\n" + "on t1.id_individu = t2.id_individu\r\n"
			+ "where t1.last = true and t2.nom = ?1 \r\n" + "or t2.prenoms = ?2", nativeQuery = true)
	int totalPage(String nom, String prenoms);

	@Query(value = "select u from AccueilMod u where u.id_acc=?1 and u.last=true")
	AccueilMod findByIdAccIsAndLast(String idAcc);

	@Query(value = "select u from AccueilMod u where u.id_individu=?1 and u.last=true order by date_dossier desc")
	List<AccueilMod> findByIdIndividuAndLast(String idIndividu);

	@Query(value = "select u from AccueilMod u where u.id_individu=?1 and u.last=true order by date_dossier desc")
	List<AccueilMod> findByIdIndividuAndLastPaginer(String idIndividu);

	@Query("select u from AccueilMod u where u.id_individu = ?1 and u.id_tec_dmd=?2 and u.last=true order by date_dossier desc")
	List<AccueilMod> findByidIndivuAndPrestation(String id_individu, String prestation);

	/**
	 * get dernier demande Ap
	 */
	@Query(value = "select distinct  acc.id_acc, acc.id_tec_dmd,  tec.id_type_info , \r\n"
			+ "tec.valeur, acc.etat, et.libelle from \"RFM\".acc_new acc \r\n"
			+ "inner join \"RFM\".tec_info_recu tec on acc.id_acc = tec.id_acc \r\n"
			+ "inner join \"RFM\".ref_etat_typ et on  acc.etat = et.id_type_etat where\r\n"
			+ "acc.id_tec_dmd = '411' and acc.id_individu = ?1 and tec.id_type_info= 45 \r\n" + "and last= true\r\n"
			+ "and valeur notnull order by valeur desc limit 1", nativeQuery = true)
	List<Object> getDerinierDmdAP(String idIndiv);
	
	@Query(value = "select distinct\r\n" + 
			"	first_value(id_individu) over(partition by id_individu order by date_insertion desc range between unbounded preceding and unbounded following) individu,\r\n" + 
			"	first_value(id_empl) over(partition by id_individu order by date_insertion desc range between unbounded preceding and unbounded following) id_empl,\r\n" + 
			"	first_value(id_acc) over(partition by id_individu order by date_insertion desc range between unbounded preceding and unbounded following) id_acc,\r\n" + 
			"	first_value(id_tec_dmd) over(partition by id_individu order by date_insertion desc range between unbounded preceding and unbounded following) id_tec_dmd,\r\n" + 
			"	first_value(date_insertion) over(partition by id_individu order by date_insertion desc range between unbounded preceding and unbounded following) date_insertion,\r\n" + 
			"	first_value(etat) over(partition by id_individu order by date_insertion desc range between unbounded preceding and unbounded following) etat,\r\n" + 
			"	first_value(num_doss) over(partition by id_individu order by date_insertion desc range between unbounded preceding and unbounded following) num_doss,\r\n" + 
			"	first_value(date_dossier) over(partition by id_individu order by date_insertion desc range between unbounded preceding and unbounded following) date_dossier\r\n" + 
			"from \"RFM\".acc_new where etat = '3' and id_tec_dmd = '411' and id_individu = ?1", nativeQuery = true)
	List<Object> findDernierDmdPf(String idIndiv);
	
	@Query(value = "SELECT valeur FROM \"RFM\".tec_info_recu WHERE id_type_info = 68 AND id_acc = ?1", nativeQuery = true)
	String dateDpa(String idAcc);
}
