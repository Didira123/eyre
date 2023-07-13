package br.com.eyre.eyre.vo;

import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class HospedagemMidiaVO {

	private Long id;

	private HospedagemVO hospedagem;

	private MidiaVO midia;

}
