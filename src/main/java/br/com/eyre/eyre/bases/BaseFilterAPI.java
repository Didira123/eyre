package br.com.eyre.eyre.bases;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

public class BaseFilterAPI<F extends BaseFilterVO<?>> {

	@PostMapping(path = {
			"/list" }, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> list(@RequestBody @Valid F filter) {
		try {
			Page<? extends BaseEntity<?>> pagination = getFilterService().findByFilter(filter);
			List<? extends BaseVO<?>> content = pagination.getContent().stream().map(ent -> (BaseVO<?>) ent.toVO())
					.collect(Collectors.toList());
			BaseListVO response = new BaseListVO(content, pagination.getTotalPages(), pagination.getTotalElements());
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(e.getCause());
		}
	}

	private BaseFilterService<F> getFilterService() {
		throw new NotImplementedException(
				"This method from " + getClass().getName() + " must be implemented at the actual subclass.");
	}

}
