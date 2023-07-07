package br.com.eyre.eyre.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OnibusVO extends TransporteVO {

	private String tipoAssento;

}
