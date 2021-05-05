package com.cnaps.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cnaps.models.DemandeMod;
import com.cnaps.models.param.DemandeFiltre;
import com.cnaps.models.param.DemandeParam;

public interface DemandeRepository extends JpaRepository<DemandeMod,String> {
	
	
	@Query(value="select u from DemandeMod u where u.etat=?1 and u.nature=?2")
	Page<DemandeMod> listeAvecParam(int etat,String prestation,Pageable page);
	
	@Query(value="select u from DemandeMod u where (u.etat=:#{#dem.type_etat} or coalesce(:#{#dem.type_etat},null) is null or :#{#dem.type_etat} = 0) and "
			+ "(u.reference = :#{#dem.reference} or :#{#dem.reference} is null or :#{#dem.reference}='') and "
			+ "(u.date_reception=:#{#dem.dateReception} or coalesce(:#{#dem.dateReception},null) is null) and "
			+ "(u.matricule=:#{#dem.matricule} or :#{#dem.matricule} is null or :#{#dem.matricule}='') and "
			+ "(u.nature=:#{#dem.prestation} or :#{#dem.prestation} is null)")
	Page<DemandeMod> findByIdIndividuAndIdAccAndDateReceptionAndIdTecDmd(@Param("dem")DemandeFiltre dem,Pageable page);
	
	@Query(value="select u from DemandeMod u where u.etat=?1 and u.matricule = ?2 and u.nature=?3")
    DemandeMod DemandeValide(int etat,String prestation,String matricule);
	
	@Query(value="select u from DemandeMod u where "
			+ " (coalesce(u.reference, :#{#dem.reference}) = :#{#dem.reference}) and (u.nature= :#{#dem.nature}) and"
			+ " (coalesce(u.date_reception, :#{#dem.date_reception} ) = :#{#dem.date_reception}) and"
			+ " (coalesce(u.matricule, :#{#dem.matricule}) =:#{#dem.matricule}) and"
			+ " (coalesce(u.etat, :#{#dem.etat})= :#{#dem.etat})")
	List<DemandeMod> advancedSearchDemande(@Param("dem")DemandeMod dem);
	
	@Query(value="select count(u) from DemandeMod u where u.etat=?1 and u.nature=?2")
	long nombreDePageParEtat(int etat,String prestation);
	
	
	@Query(value="select u from DemandeMod u where"
			+ " (u.nature='430') and"
			+ " (u.reference like concat('%',:#{#dem.reference}) or :#{#dem.reference} = '') and"
			+ " (u.matricule = :#{#dem.matricule}  or :#{#dem.matricule} ='') and"
			+ " (u.etat = :#{#dem.etat}  or :#{#dem.etat} is 0)")
	List<DemandeMod> searchAvancedNoDate(@Param("dem")DemandeMod dem,Pageable page);
	
	
	@Query(value="select u from DemandeMod u where"
			+ " (u.nature='430') and"
			+ " (u.reference like concat('%',:#{#dem.reference}) or :#{#dem.reference} = '') and"
			+ " (u.matricule = :#{#dem.matricule}  or :#{#dem.matricule} ='') and"
			+ " (u.etat = :#{#dem.etat}  or :#{#dem.etat} is 0) and"
			+ " (u.date_reception = :#{#dem.date_reception})")
	List<DemandeMod> searchAvanced(@Param("dem")DemandeMod dem,Pageable page);
	
	@Query(value="select u from DemandeMod u where u.nature='430' and u.reference=?1")
	DemandeMod findByReference(String reference);
	
	@Query(value="select u from DemandeMod u where u.nature='430'")
	List<DemandeMod> searchAll(Pageable page);
	
	List<DemandeMod> findByMatricule(String matricule);
	
	@Query(value="select u from DemandeMod u where"
			+ " (u.nature='430') and"
			+ " (u.reference like concat('%',:#{#dem.filtre.dr}) or :#{#dem.filtre.dr} = '') and"
			+ " (u.matricule = :#{#dem.filtre.idIndividu}  or :#{#dem.filtre.idIndividu} ='') and"
			+ " (u.reference = :#{#dem.filtre.reference}  or :#{#dem.filtre.reference} ='') and"
			+ " (u.etat = :#{#dem.filtre.etat}  or :#{#dem.filtre.etat} is 0) and"
			+ " (u.date_reception = :#{#dem.filtre.date} or coalesce(:#{#dem.filtre.date}, null) is null )")
	List<DemandeMod> findAllDmd(@Param("dem")DemandeParam dem,Pageable page);
	
	
	@Query(value="select u from DemandeMod u where"
			+ " (u.nature='461') and"
			+ " (u.etat = :#{#dem.filtre.etat} or :#{#dem.filtre.etat} is 0) and"
			+ " (u.matricule = :#{#dem.filtre.idIndividu}  or :#{#dem.filtre.idIndividu} = '') and"
			+ " (u.date_reception = :#{#dem.filtre.date} or coalesce(:#{#dem.filtre.date},null) is null)")
	List<DemandeMod> findAllDmdEnfant(@Param("dem")DemandeParam dem,Pageable page);
}
