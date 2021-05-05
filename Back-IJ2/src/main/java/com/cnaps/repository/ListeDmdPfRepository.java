package com.cnaps.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cnaps.models.ListeDmdPf;
import com.cnaps.models.param.DemandeFiltre;

public interface ListeDmdPfRepository extends JpaRepository<ListeDmdPf, String> {

	@Query(value = "select u from ListeDmdPf u where u.last = true and "
			+ "(u.etat=:#{#dem.type_etat} or coalesce(:#{#dem.type_etat},null) is null or :#{#dem.type_etat} = 0) and "
			+ "(u.id_acc = :#{#dem.reference} or :#{#dem.reference} is null or :#{#dem.reference}='') and "
			+ "(u.dateInsertion=:#{#dem.dateReception} or coalesce(:#{#dem.dateReception},null) is null) and "
			+ "(u.id_individu=:#{#dem.matricule} or :#{#dem.matricule} is null or :#{#dem.matricule}='') and"
			+ "(u.nom=:#{#dem.nom} or :#{#dem.nom} is null or :#{#dem.nom}='') and"
			+ "(u.prenoms=:#{#dem.prenom} or :#{#dem.prenom} is null or :#{#dem.prenom}='') and "
			+ "(u.id_tec_dmd=:#{#dem.prestation} or :#{#dem.prestation} is null or :#{#dem.prestation}='') order by u.dateInsertion desc, u.id_acc desc")
	Page<ListeDmdPf> findByIdIndividuAndIdAccAndDateReceptionAndIdTecDmd(@Param("dem") DemandeFiltre dem,
			Pageable page);

}
