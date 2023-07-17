package br.com.eyre.eyre.bases;

import java.util.Optional;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class BaseAPI<ID, E extends BaseEntity<ID>, V extends BaseVO<ID>, S extends BaseService<ID, E>> {

//	@PostMapping("/")
//	public ResponseEntity<V> create(V vo, BindResult<?> result) {
//		
//		BaseService service = (BaseService) S;
//		service.
//		return null;
//	}

	@GetMapping(path = { "/{id}" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<? extends BaseVO<ID>> findById(@PathVariable("id") ID id) {
		Optional<? extends BaseEntity<ID>> optional = getService().findById(id);
		if (optional.isPresent()) {
			try {
				BaseVO<ID> vo = optional.get().toVO();
				return ResponseEntity.ok(vo);
			} catch (NotImplementedException ex) {
				ex.printStackTrace();
				return ResponseEntity.internalServerError().build();
			}
		}
		return ResponseEntity.notFound().build();
	}

	private S getService() {
		throw new NotImplementedException(
				"This method from " + getClass().getName() + " must be implemented at the actual subclass.");
	}

}
