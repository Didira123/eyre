package br.com.eyre.eyre.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import br.com.eyre.eyre.entity.Endereco;
import br.com.eyre.eyre.entity.Role;
import br.com.eyre.eyre.entity.Usuario;
import br.com.eyre.eyre.repository.UsuarioRepository;
import br.com.eyre.eyre.service.EnderecoService;
import br.com.eyre.eyre.service.UsuarioService;
import br.com.eyre.eyre.vo.UsuarioNovoVO;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<Usuario> users = usuarioRepository.findByEmail(username);
		if (users.isEmpty()) {
			throw new UsernameNotFoundException("Dados inválidos!");
		}
//		if (users.size() > 1) {
//			throw new RuntimeException("Múltiplos Usuários para o cpf_cnpj \"" + username + "\"");
//		}

		return users.get(0);
	}

	@Override
	public Optional<Usuario> findById(Long id) {
		return usuarioRepository.findById(id);
	}

	@Transactional()
	@Override
	public Usuario create(UsuarioNovoVO vo, BindingResult result) {
		Usuario entity = new Usuario();
		entity.setCpfCnpj(vo.getCpfCnpj());
		entity.setNome(vo.getNome());
		entity.setEmail(vo.getEmail());
		entity.setSenha(encoder.encode(vo.getSenha()));
		entity.setDataNascimento(vo.getDataNascimento());
		entity.setTelefone(vo.getTelefone());
		entity.setRole(new Role(Role.USUARIO_COMUM));
		entity.setAtivo(true);

		if (vo.getEndereco() != null) {
			Endereco endereco = enderecoService.create(vo.getEndereco(), result);
			entity.setEndereco(new Endereco(endereco.getId()));
		}

		return usuarioRepository.save(entity);
	}

}
