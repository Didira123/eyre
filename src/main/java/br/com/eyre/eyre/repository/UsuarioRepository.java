package br.com.eyre.eyre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eyre.eyre.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public List<Usuario> findByEmail(String username);

}
