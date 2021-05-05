package com.cnaps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cnaps.models.TecMemoMod;

public interface TecMemoRepository extends JpaRepository<TecMemoMod, String> {
	List<TecMemoMod> findByIdIndividu(String idIndividu);
}
