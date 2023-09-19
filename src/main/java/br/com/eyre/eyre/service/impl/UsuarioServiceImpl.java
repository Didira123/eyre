package br.com.eyre.eyre.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import br.com.eyre.eyre.bases.CrudBaseServiceImpl;
import br.com.eyre.eyre.entity.Endereco;
import br.com.eyre.eyre.entity.Usuario;
import br.com.eyre.eyre.repository.UsuarioRepository;
import br.com.eyre.eyre.service.EnderecoService;
import br.com.eyre.eyre.service.MidiaService;
import br.com.eyre.eyre.service.RoleService;
import br.com.eyre.eyre.service.UsuarioService;
import br.com.eyre.eyre.utils.FormatterUtils;
import br.com.eyre.eyre.vo.EnderecoVO;
import br.com.eyre.eyre.vo.UsuarioMeVO;
import br.com.eyre.eyre.vo.UsuarioNovoVO;

@Service
public class UsuarioServiceImpl extends CrudBaseServiceImpl<Long, Usuario, UsuarioNovoVO>
		implements UserDetailsService, UsuarioService {

	private static final String USUARIO_COMUM = "Usuário Comum";

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private RoleService roleService;

	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	private MidiaService midiaService;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	protected JpaRepository<Usuario, Long> getRepository() {
		return usuarioRepository;
	}

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

	@Transactional()
	@Override
	public Usuario create(UsuarioNovoVO vo, BindingResult result) {
		Usuario entity = new Usuario();
		entity.setCpfCnpj(vo.getCpfCnpj());
		entity.setNome(vo.getNome());
		entity.setEmail(vo.getEmail());
		entity.setSenha(encoder.encode(vo.getSenha()));
		entity.setDataNascimento(vo.getDataNascimento());
		entity.setTelefone(FormatterUtils.numbers(vo.getTelefone()));
		entity.setRole(roleService.findByNome(USUARIO_COMUM));
		entity.setAtivo(true);

		EnderecoVO enderecoVO = vo.getEndereco();
		if (enderecoVO != null) {
			Endereco endereco;
			if (enderecoVO.getId() != null) {
				endereco = enderecoService.findById(enderecoVO.getId()).get();
			} else {
				endereco = enderecoService.create(vo.getEndereco(), result);
			}
			entity.setEndereco(new Endereco(endereco.getId()));
		}

		return usuarioRepository.save(entity);
	}

	@Override
	public Usuario update(Usuario entity, UsuarioNovoVO vo, BindingResult result) {
//		entity.setCpfCnpj(vo.getCpfCnpj());
		entity.setNome(vo.getNome());
		entity.setEmail(vo.getEmail());
//		entity.setSenha(encoder.encode(vo.getSenha()));
//		entity.setDataNascimento(vo.getDataNascimento());
		entity.setTelefone(vo.getTelefone());
//		entity.setRole(roleService.findByNome(USUARIO_COMUM));
//		entity.setAtivo(true);
		if(vo.getFoto().getId() == null){
			entity.setFoto(midiaService.create(vo.getFoto(), result));
		}
			
		EnderecoVO enderecoVO = vo.getEndereco();
		if (enderecoVO != null) {
			Endereco endereco;
			if (enderecoVO.getId() != null) {
				endereco = enderecoService.findById(enderecoVO.getId()).get();
			} else {
				endereco = enderecoService.create(vo.getEndereco(), result);
			}
			entity.setEndereco(new Endereco(endereco.getId()));
		}

		return usuarioRepository.save(entity);
	}

	@Override
	public Optional<Usuario> findById(Long id) {
		return usuarioRepository.findById(id);
	}

	@Override
	public UsuarioMeVO findUsuarioAndPermissionsById(Long id) {
		return usuarioRepository.findUsuarioAndPermissionsById(id);
	}

}
