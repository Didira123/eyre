package br.com.eyre.eyre.vo;

import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class HospedagemVO {

	private Long id;

	private String nome;

	private Integer avaliacao;

	private String descricao;

	private EnderecoVO endereco;

}
