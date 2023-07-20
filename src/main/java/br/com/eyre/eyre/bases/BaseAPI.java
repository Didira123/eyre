package br.com.eyre.eyre.bases;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class BaseAPI<ID extends Serializable, E extends BaseEntity<ID>, VRQ extends BaseVO<ID>, VRP extends BaseVO<ID>, S extends BaseService<ID, E>> {

//	@PostMapping("/")
//	public ResponseEntity<V> create(V vo, BindResult<?> result) {
//		
//		BaseService service = (BaseService) S;
//		service.
//		return null;
//	}

	@GetMapping(path = { "/findAll" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findAll() {
		try {
			List<?> lista = getService().findAll();
			return ResponseEntity.ok(lista);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getCause());
		}
	}

	@GetMapping(path = { "/{id}" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findById(@PathVariable("id") ID id) {
		Optional<? extends BaseEntity<ID>> optional = getService().findById(id);
		if (optional.isPresent()) {
			try {
				BaseVO<ID> vo = optional.get().toVO();
				return ResponseEntity.ok(vo);
			} catch (NotImplementedException ex) {
				ex.printStackTrace();
				return ResponseEntity.internalServerError().body(ex.getCause());
			}
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> deleteById(@PathVariable("id") ID id) {
		try {
			getService().deleteById(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(e.getCause());
		}
	}

	private S getService() {
		throw new NotImplementedException(
				"This method from " + getClass().getName() + " must be implemented at the actual subclass.");
	}

}
