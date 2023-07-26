package br.com.eyre.eyre.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eyre.eyre.entity.Role;
import br.com.eyre.eyre.repository.RoleRepository;
import br.com.eyre.eyre.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role findByNome(String nome) {
		return roleRepository.findByNome(nome);
	}

}
