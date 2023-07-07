package br.com.eyre.eyre.vo;

import lombok.Data;

@Data
public class AvaliacaoVO {

	private Long id;

	private UsuarioVO usuario;

	private HospedagemVO hospedagem;

	private String texto;

}