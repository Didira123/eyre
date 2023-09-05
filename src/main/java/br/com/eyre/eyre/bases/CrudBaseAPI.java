package br.com.eyre.eyre.bases;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import br.com.eyre.eyre.exceptions.NotAllowedException;
import jakarta.validation.Valid;

//informar o ID (ID),  Classe VO de Request (VRQ), Classe Entidade (E), Classe Serviço (S)
public class CrudBaseAPI<ID extends Serializable, E extends BaseEntity<ID>, VRQ extends BaseVO<ID>, S extends CrudBaseService<ID, E, VRQ>>
		extends BaseAPI<ID, E, VRQ, S> {

	@PostMapping(path = { "/" }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@RequestBody @Valid VRQ vo, BindingResult result) {
		try {
			ID idSaved = getService().create(vo, result).getId();
			UriComponents uriComponents = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(idSaved);
			return ResponseEntity.created(uriComponents.toUri()).build();
		} catch (NotAllowedException e) {
//			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("Create not supported");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}

	@PutMapping(path = { "/" }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody @Valid VRQ vo, BindingResult result) {
		try {
			Optional<E> entity = getService().findById((ID) vo.getId());
			if (!entity.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			ID idSaved = getService().update(entity.get(), vo, result).getId();
			UriComponents uriComponents = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(idSaved);
			return ResponseEntity.ok(uriComponents.toUri());
		} catch (NotAllowedException e) {
//			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("Update not supported");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> deleteById(@PathVariable("id") ID id) {
		try {
			Optional<E> entity = getService().findById(id);
			if (!entity.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			getService().deleteById(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}

}
