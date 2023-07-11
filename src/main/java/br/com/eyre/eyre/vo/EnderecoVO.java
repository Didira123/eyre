package br.com.eyre.eyre.vo;

import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class EnderecoVO {

	private Long id;

	private String cep;

	private String pais;

	private String estado;

	private String cidade;
	
	private String bairro;

	private String rua;

	private String numero;

}
