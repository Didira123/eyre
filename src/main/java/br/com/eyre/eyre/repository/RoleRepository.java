package br.com.eyre.eyre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eyre.eyre.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	public Role findByNome(String nome);

}
