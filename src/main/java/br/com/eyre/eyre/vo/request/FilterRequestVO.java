package br.com.eyre.eyre.vo.request;

import java.io.Serializable;

import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class FilterRequestVO<V extends Serializable> implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer page;

	private Integer pageSize;

	private String order;

	private String direction;

	private V content;

	public FilterRequestVO() {

	}

}
