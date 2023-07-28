package br.com.eyre.eyre.bases;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

public interface BaseFilterAPI<F extends BaseFilterVO<?>> {

	@PostMapping(path = {
			"/list" }, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	default public ResponseEntity<?> list(@RequestBody @Valid F filter) {
		try {
			Page<? extends BaseVO<?>> pagination = getFilterService().findByFilter(filter);
			BaseListVO response = new BaseListVO(pagination.getContent(), pagination.getTotalPages(), pagination.getTotalElements());
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}

	public BaseFilterService<F> getFilterService();

}
