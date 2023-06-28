package br.com.eyre.eyre.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UsuarioService extends UserDetailsService{

	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
	
}
