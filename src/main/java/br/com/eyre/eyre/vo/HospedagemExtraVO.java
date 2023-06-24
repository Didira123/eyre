package br.com.eyre.eyre.vo;

import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class HospedagemExtraVO {

	private Long id;

	private HospedagemVO hospedagem;

	private ExtraVO extra;

}
