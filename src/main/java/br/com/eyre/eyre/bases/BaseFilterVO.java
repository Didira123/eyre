package br.com.eyre.eyre.bases;

import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class BaseFilterVO<F> {

	private Integer page;

	private Integer pageSize;

	private String order;

	private String direction;

	private F filter;

	public BaseFilterVO() {
		super();
		this.page = 0;
		this.pageSize = 10;
	}

	public BaseFilterVO(Integer page, Integer pageSize, String order) {
		super();
		this.page = (page==null?0:page);
		this.pageSize = (pageSize==null?10:pageSize);
		this.order = (order==null?"id":order);
	}

}
