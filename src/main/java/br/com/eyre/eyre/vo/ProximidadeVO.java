package br.com.eyre.eyre.vo;

import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class ProximidadeVO {

	private Long id;

	private EstabelecimentoVO estabelecimento;

	private String descricao;

	private EnderecoVO endereco;

}
