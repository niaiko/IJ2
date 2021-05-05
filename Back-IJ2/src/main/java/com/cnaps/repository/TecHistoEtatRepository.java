package com.cnaps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cnaps.models.TecHistoEtatMod;

public interface TecHistoEtatRepository extends JpaRepository<TecHistoEtatMod, String> {

	List<TecHistoEtatMod> findByidacc(String idacc);

}
