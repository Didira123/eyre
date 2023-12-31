package br.com.eyre.eyre.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.BindingResult;

import br.com.eyre.eyre.bases.CrudBaseService;
import br.com.eyre.eyre.entity.Usuario;
import br.com.eyre.eyre.vo.UsuarioMeVO;
import br.com.eyre.eyre.vo.UsuarioNovoVO;

public interface UsuarioService extends UserDetailsService, CrudBaseService<Long, Usuario, UsuarioNovoVO> {

	public Optional<Usuario> findById(Long id);

	public Usuario create(UsuarioNovoVO vo, BindingResult result);

	public UsuarioMeVO findUsuarioAndPermissionsById(Long id);

}
