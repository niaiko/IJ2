package com.cnaps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cnaps.models.TecPcsRecMod;

public interface TecPcsRecRepository extends JpaRepository<TecPcsRecMod,String> {
	@Query(value="select u from TecPcsRecMod u where u.id_acc=?1")
	List<TecPcsRecMod> findByIdAccueil(String id_acc);
}
