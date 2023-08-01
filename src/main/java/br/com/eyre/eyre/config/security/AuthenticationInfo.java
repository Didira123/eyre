package br.com.eyre.eyre.config.security;

import br.com.eyre.eyre.entity.Usuario;

public interface AuthenticationInfo {

	public Usuario getUsuario();

//	public Role getUserRole();

	public Long getAccessLevel();

}
