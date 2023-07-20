package br.com.eyre.eyre.bases;

import java.util.List;

import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class BaseListVO {

	private List<? extends BaseVO<?>> content;
	private Integer totalPages;
	private Long totalElements;

	public BaseListVO() {
	}

	public BaseListVO(List<? extends BaseVO<?>> content, Integer totalPages, Long totalElements) {
		super();
		this.content = content;
		this.totalPages = totalPages;
		this.totalElements = totalElements;
	}

}
