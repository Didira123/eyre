package br.com.eyre.eyre.bases;

import java.io.Serializable;

import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class BaseFilterVO<F extends Serializable> implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer page;

	private Integer pageSize;

	private String order;

	private String direction;

	private F content;

	public BaseFilterVO() {
		super();
		this.page = 0;
		this.pageSize = 10;
	}

	public BaseFilterVO(Integer page, Integer pageSize, String order, String direction) {
		super();
		this.page = (page == null ? 0 : page);
		this.pageSize = (pageSize == null ? 10 : pageSize);
		this.order = (order == null ? "id" : order);
		this.direction = (direction == null ? "" : direction);
	}

}
