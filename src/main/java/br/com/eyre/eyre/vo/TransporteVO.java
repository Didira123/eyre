package br.com.eyre.eyre.vo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import br.com.eyre.eyre.bases.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonTypeInfo(use = Id.NAME, property = "type")
@JsonSubTypes({ @Type(value = CompanhiaAereaVO.class, name = TransporteVO.COMPANHIA_AEREA),
		@Type(value = OnibusVO.class, name = TransporteVO.ONIBUS) })
public class TransporteVO extends BaseVO<Long> {

	private static final long serialVersionUID = 1L;

	public static final String COMPANHIA_AEREA = "0";
	public static final String ONIBUS = "1";

	private String nome;

	private EnderecoVO localSaida;

	private EnderecoVO localChegada;

	private Set<TransporteEnderecoVO> listTransporteEnderecos = new HashSet<>();

	private List<TransporteDiaVO> listTransporteDias = new ArrayList<>();

	private MidiaVO midia;

	private BigDecimal preco;

}
