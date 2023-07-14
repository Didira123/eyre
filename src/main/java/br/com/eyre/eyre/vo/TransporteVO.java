package br.com.eyre.eyre.vo;

import java.math.BigDecimal;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
@JsonTypeInfo(use = Id.NAME, property = "type")
@JsonSubTypes({ @Type(value = CompanhiaAereaVO.class, name = TransporteVO.COMPANHIA_AEREA),
		@Type(value = OnibusVO.class, name = TransporteVO.ONIBUS) })
public class TransporteVO {

	public static final String COMPANHIA_AEREA = "0";
	public static final String ONIBUS = "1";

	private Long id;

	private String nome;

	private LocalTime horarioPartida;

	private LocalTime horarioChegada;

	private EnderecoVO localSaida;

	private EnderecoVO localChegada;

	private BigDecimal preco;

}
