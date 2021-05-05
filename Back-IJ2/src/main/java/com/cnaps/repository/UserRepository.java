package com.cnaps.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cnaps.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
	Optional<User> findByMatricule(String matricule);

	boolean existsByMatricule(String matricule);
	boolean existsByUsername(String username);
	boolean existsByEmail(String email);

}
