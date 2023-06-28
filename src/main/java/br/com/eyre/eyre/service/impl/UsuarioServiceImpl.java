package br.com.eyre.eyre.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.eyre.eyre.entity.Usuario;
import br.com.eyre.eyre.repository.UsuarioRepository;
import br.com.eyre.eyre.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<Usuario> users = usuarioRepository.findByCpfCnpj(username);
		if (users.size() > 1) {
			throw new RuntimeException("Múltiplos Usuários para o cpf_cnpj \"" + username + "\"");
		}

		return users.get(0);
	}

}
