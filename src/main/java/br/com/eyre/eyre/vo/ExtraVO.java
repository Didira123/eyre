package br.com.eyre.eyre.vo;

import br.com.eyre.eyre.enums.ExtraEnum;
import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class ExtraVO {

	private Long id;

	private String nome;
	
	private ExtraEnum tipoExtra;

}
