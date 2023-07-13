package br.com.eyre.eyre.vo;

import br.com.eyre.eyre.enums.ProximidadeEnum;
import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class ProximidadeVO {

	private Long id;

	private String nome;

	private ProximidadeEnum tipoProximidade;

	private String descricao;

	private MidiaVO foto;

	private EnderecoVO endereco;

}
