package br.com.eyre.eyre.vo;

import br.com.eyre.eyre.bases.BaseVO;
import br.com.eyre.eyre.enums.MidiaEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MidiaVO extends BaseVO<Long> {

	private static final long serialVersionUID = 1L;

	private String nome;

	private MidiaEnum tipoMidia;

	private byte[] dados;

}
