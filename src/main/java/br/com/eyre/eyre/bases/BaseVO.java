package br.com.eyre.eyre.bases;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@JsonInclude(Include.NON_NULL)
@Data
public class BaseVO<I extends Serializable> implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

}
