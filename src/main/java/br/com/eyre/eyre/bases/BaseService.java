package br.com.eyre.eyre.bases;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

//informar o ID (ID), Classe Entidade (E)
public interface BaseService<ID extends Serializable, E extends BaseEntity<ID>> {

	public List<E> findAll();

	public Optional<E> findById(ID id);

}
