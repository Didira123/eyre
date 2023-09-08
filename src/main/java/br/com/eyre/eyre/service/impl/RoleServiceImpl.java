package br.com.eyre.eyre.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.eyre.eyre.bases.BaseServiceImpl;
import br.com.eyre.eyre.entity.Role;
import br.com.eyre.eyre.repository.RoleRepository;
import br.com.eyre.eyre.service.RoleService;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Long, Role> implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	protected JpaRepository<Role, Long> getRepository() {
		return roleRepository;
	}

	@Override
	public Role findByNome(String nome) {
		return roleRepository.findByNome(nome);
	}

}
