package br.com.eyre.eyre.bases;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;

//informar o ID (ID), Classe Entidade (E), Classe VO (V), Classe Repositório (R)
public class BaseServiceImpl<ID extends Serializable, E extends BaseEntity<ID>> implements BaseService<ID, E> {

	@Override
	public List<E> findAll() {
		return getRepository().findAll(Sort.by(Direction.ASC, "id"));
	}

	@Override
	public Optional<E> findById(ID id) {
		return getRepository().findById(id);
	}

	protected JpaRepository<E, ID> getRepository() {
		throw new NotImplementedException(
				"This method from " + getClass().getName() + " must be implemented at the actual subclass.");
	}

}
