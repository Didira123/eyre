package br.com.eyre.eyre.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import br.com.eyre.eyre.bases.BaseServiceImpl;
import br.com.eyre.eyre.entity.Extra;
import br.com.eyre.eyre.repository.ExtraRepository;

public class ExtraServiceImpl extends BaseServiceImpl<Long, Extra> {
	
	@Autowired
	private ExtraRepository extraRepository;
	
	@Override
	public List<Extra> findAll() {
		return extraRepository.findAll(Sort.by(Direction.ASC, "nome"));
	}
	
}
