package br.com.eyre.eyre.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CompanhiaAereaVO extends TransporteVO {

	private static final long serialVersionUID = 1L;

	private Boolean escala;

}
