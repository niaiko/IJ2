package com.cnaps.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.cnaps.models.TecEtatDossMod;

public interface TecEtatDossRepository extends JpaRepository<TecEtatDossMod,Integer> {
	
	@Transactional
	@Modifying
	@Query(value="UPDATE TecEtatDossMod SET id_type_etat = ?2 WHERE id_acc=?1 ")
	void updateEtatDemande(String idacc, int etat);
	
	@Query(value="SELECT u from TecEtatDossMod u where u.id_acc=?1")
	List<TecEtatDossMod> findByIdAcc(String idacc, Pageable page);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE TecEtatDossMod SET id_op =?1,date_etat=?2 WHERE id_acc=?3 ")
	void updateOp(String numOp,Date date_etat,String idAcc);
		
	@Query(value="select u from TecEtatDossMod u where u.id_op is not null")
	List<TecEtatDossMod> findAllWithNumOp();
	
	
	
	
	
}
