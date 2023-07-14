package br.com.eyre.eyre.bases;

import java.util.List;
import java.util.Optional;

//informar o ID (ID), Classe Entidade (E), Classe VO (V), Classe Repositório (R)
public interface BaseService<ID, E extends BaseEntity<ID>> {

	public List<E> findAll();

	public Optional<E> findById(ID id);
	
}
