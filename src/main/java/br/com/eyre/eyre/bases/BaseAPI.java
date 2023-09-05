package br.com.eyre.eyre.bases;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class BaseAPI<ID extends Serializable, E extends BaseEntity<ID>, VRQ extends BaseVO<ID>, S extends BaseService<ID, E>> {

	@GetMapping(path = { "/findAll" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findAll() {
		try {
			List<? extends BaseVO<ID>> listVOs = getService().findAll().stream().map(e -> (BaseVO<ID>) e.toVO())
					.collect(Collectors.toList());
			return ResponseEntity.ok(listVOs);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}

	@GetMapping(path = { "/{id}" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findById(@PathVariable("id") ID id) {
		Optional<? extends BaseEntity<ID>> optional = getService().findById(id);
		if (optional.isPresent()) {
			try {
				BaseVO<ID> vo = optional.get().toVO();
				return ResponseEntity.ok(vo);
			} catch (NotImplementedException e) {
				e.printStackTrace();
				return ResponseEntity.internalServerError().body(e.getMessage());
			}
		}
		return ResponseEntity.notFound().build();
	}

	protected S getService() {
		throw new NotImplementedException(
				"This method from " + getClass().getName() + " must be implemented at the actual subclass.");
	}

}
