package br.com.eyre.eyre.bases;

import java.io.Serializable;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.validation.BindingResult;

import br.com.eyre.eyre.exceptions.NotAllowedException;

//informar o ID (ID), Classe Entidade (E), Classe VO (V)
public class CrudBaseServiceImpl<ID extends Serializable, E extends BaseEntity<ID>, VRQ extends BaseVO<ID>>
		extends BaseServiceImpl<ID, E> implements CrudBaseService<ID, E, VRQ> {

	@Override
	public E create(VRQ vo, BindingResult result) {
		throw new NotAllowedException(
				"This method from " + getClass().getName() + " is not implemented, meaning not allowed.");
	}

	@Override
	public E update(E entity, VRQ vo, BindingResult result) {
		throw new NotImplementedException(
				"This method from " + getClass().getName() + " is not implemented, meaning not allowed.");
	}

	@Override
	public void deleteById(ID id) {
		getRepository().deleteById(id);
	}

}
