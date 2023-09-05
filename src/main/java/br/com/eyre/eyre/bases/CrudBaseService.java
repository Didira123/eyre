package br.com.eyre.eyre.bases;

import java.io.Serializable;

import org.springframework.validation.BindingResult;

//informar o ID (ID), Classe Entidade (E), Classe VO (V)
public interface CrudBaseService<ID extends Serializable, E extends BaseEntity<ID>, VRQ extends BaseVO<ID>>
		extends BaseService<ID, E> {

	public E create(VRQ vo, BindingResult result);

	public E update(E entity, VRQ vo, BindingResult result);

	public void deleteById(ID id);

}
