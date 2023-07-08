package br.com.eyre.eyre.vo;

import br.com.eyre.eyre.enums.EnderecoEnum;
import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class TransporteEnderecoVO {

	private Long id;

	private TransporteVO transporte;

	private EnderecoVO endereco;

	private EnderecoEnum tipoEndereco;

}
