package br.com.eyre.eyre.vo;

import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class PacoteViagemTuristaVO {

	private Long id;

	private PacoteViagemVO pacoteViagem;

	private TuristaVO turista;

}
