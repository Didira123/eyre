package br.com.eyre.eyre.vo;

import lombok.Data;

@Data
public class HospedagemProximidadeVO {

	private Long id;

	private HospedagemVO hospedagem;

	private ProximidadeVO proximidade;

}
