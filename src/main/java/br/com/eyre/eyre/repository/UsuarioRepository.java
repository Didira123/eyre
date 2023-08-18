package br.com.eyre.eyre.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.eyre.eyre.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public List<Usuario> findByEmail(String username);
	
	@Query(value = "SELECT u FROM Usuario u "
			+ " INNER JOIN FETCH u.role r "
			+ " INNER JOIN FETCH u.endereco "
			+ " LEFT JOIN FETCH u.foto f "
			+ " WHERE u.id=:id ")
	public Optional<Usuario> findById(Long id);
	
}
