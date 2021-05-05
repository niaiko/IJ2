package com.cnaps.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cnaps.models.ParametrePfMod;


public interface ParametrePfRepository extends JpaRepository<ParametrePfMod,Integer> {
	@Query("select u from ParametrePfMod u where u.id_ref_param_pf=?1")
	List<ParametrePfMod> findByParamPf(int param_pf,Pageable page);
}
