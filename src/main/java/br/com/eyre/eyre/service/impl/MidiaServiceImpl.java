package br.com.eyre.eyre.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.validation.BindingResult;

import br.com.eyre.eyre.bases.CrudBaseServiceImpl;
import br.com.eyre.eyre.entity.Midia;
import br.com.eyre.eyre.repository.MidiaRepository;
import br.com.eyre.eyre.service.MidiaService;
import br.com.eyre.eyre.vo.MidiaVO;

public class MidiaServiceImpl extends CrudBaseServiceImpl<Long, Midia, MidiaVO> implements MidiaService {

	@Autowired
	private MidiaRepository midiaRepository;

	@Override
	protected JpaRepository<Midia, Long> getRepository() {
		return midiaRepository;
	}

	@Override
	public Midia create(MidiaVO vo, BindingResult result) {
		Midia entity = new Midia();
		entity.setNome(vo.getNome());
		entity.setTipoMidia(vo.getTipoMidia());
		entity.setDados(vo.getByteArrayFrom64());

		return midiaRepository.save(entity);
	}

}
