package br.com.eyre.eyre.bases;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;

//informar o ID (ID), Classe Entidade (E), Classe VO (V), Classe Repositório (R)
public class BaseService<ID, E extends BaseEntity<ID>, V extends BaseVO<ID>, R extends JpaRepository<E, ID>> {
	
	private R repository;
	
//	public V create(V vo, BindResult result) {
//		return repository.
//	}
	
	public List<E> findAll(){
		return repository.findAll(Sort.by(Direction.ASC, "id"));
	}
	
}
