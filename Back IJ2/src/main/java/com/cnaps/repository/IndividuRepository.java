package com.cnaps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cnaps.models.Individu;
import com.cnaps.models.param.DemandeFiltre;

public interface IndividuRepository extends JpaRepository<Individu, String> {

	Individu findByIdIndividu(String individu);

	@Query(value = "select u from Individu u where (u.nom = :#{#dem.nom} or :#{#dem.nom} is null or :#{#dem.nom}='') and"
			+ "(u.prenoms = :#{#dem.prenom} or :#{#dem.prenom} is null or :#{#dem.prenom}='')")
	List<Individu> searchIndividu(@Param("dem") DemandeFiltre dem);
}
