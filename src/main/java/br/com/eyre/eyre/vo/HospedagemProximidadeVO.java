package br.com.eyre.eyre.vo;

import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class HospedagemProximidadeVO {

	private Long id;

	private HospedagemVO hospedagem;

	private ProximidadeVO proximidade;

}
