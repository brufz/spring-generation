package com.generation.lojagames.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.generation.lojagames.model.UsuarioModel;
import com.generation.lojagames.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	public UsuarioRepository userRepository;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UsuarioModel> user = userRepository.findByUsuario(username);
		user.orElseThrow(() -> new UsernameNotFoundException(username + "not found"));
		
		return user.map(UserDetailsImpl::new).get();
	}

}

