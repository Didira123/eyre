package br.com.eyre.eyre.vo;

import br.com.eyre.eyre.enums.AssentoEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OnibusVO extends TransporteVO {

	private static final long serialVersionUID = 1L;

	private AssentoEnum tipoAssento;

}
