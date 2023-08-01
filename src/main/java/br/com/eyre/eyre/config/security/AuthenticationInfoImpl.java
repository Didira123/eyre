package br.com.eyre.eyre.config.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import br.com.eyre.eyre.entity.Usuario;

@Component
public class AuthenticationInfoImpl implements AuthenticationInfo {

	@Override
	public Usuario getUsuario() {
		return (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	@Override
	public Long getAccessLevel() {
		return getUsuario().getRole().getAccessLevel();
	}

}
