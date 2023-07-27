package br.com.eyre.eyre.vo;

import br.com.eyre.eyre.bases.BaseVO;
import br.com.eyre.eyre.enums.ExtraEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ExtraVO extends BaseVO<Long> {

	private static final long serialVersionUID = 1L;

	private String nome;

	private ExtraEnum tipoExtra;

}
