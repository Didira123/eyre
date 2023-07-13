package br.com.eyre.eyre.vo;

import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class AvaliacaoVO {

	private Long id;

	private UsuarioVO usuario;

	private HospedagemVO hospedagem;

	private String texto;

}