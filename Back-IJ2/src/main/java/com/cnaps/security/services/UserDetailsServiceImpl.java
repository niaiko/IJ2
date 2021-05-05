package com.cnaps.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cnaps.models.User;
import com.cnaps.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String matricule) throws MatriculeNotFoundException {
		User user = userRepository.findByMatricule(matricule)
				.orElseThrow(() -> new MatriculeNotFoundException("User Not Found with matricule: " + matricule));

		return UserDetailsImpl.build(user);
	}

}
