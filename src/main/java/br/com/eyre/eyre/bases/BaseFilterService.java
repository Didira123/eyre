package br.com.eyre.eyre.bases;

import org.springframework.data.domain.Page;

public interface BaseFilterService<F extends BaseFilterVO<?>> {

	public Page<? extends BaseVO<?>> findByFilter(F filter);

}
