package br.com.eyre.eyre.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import br.com.eyre.eyre.bases.CrudBaseServiceImpl;
import br.com.eyre.eyre.entity.Extra;
import br.com.eyre.eyre.repository.ExtraRepository;
import br.com.eyre.eyre.service.ExtraService;
import br.com.eyre.eyre.vo.ExtraVO;

public class ExtraServiceImpl extends CrudBaseServiceImpl<Long, Extra, ExtraVO> implements ExtraService {

	@Autowired
	private ExtraRepository extraRepository;

	@Override
	protected JpaRepository<Extra, Long> getRepository() {
		return extraRepository;
	}

	@Override
	public List<Extra> findAll() {
		return extraRepository.findAll(Sort.by(Direction.ASC, "nome"));
	}

	@Transactional()
	@Override
	public Extra create(ExtraVO vo, BindingResult result) {
		Extra entity = new Extra();
		entity.setNome(vo.getNome());
		return extraRepository.save(entity);
	}

	@Override
	public Optional<Extra> findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

}
