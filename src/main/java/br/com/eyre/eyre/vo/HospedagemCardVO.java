package br.com.eyre.eyre.vo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.eyre.eyre.bases.BaseVO;
import br.com.eyre.eyre.enums.QuartoEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

//TODO INUTILIZADO NO MOMENTO (ESTÁ SENDO UTILIZADO O HOSPEDAGEMVO NO MOMENTO ATÉ DEFINIR OS JSON/VO'S)
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class HospedagemCardVO extends BaseVO<Long> {

	private static final long serialVersionUID = 1L;

	private String titulo;

	private QuartoEnum tipoQuarto;

	private String descricaoQuarto;

	private Integer quantidadeReservas;

	private List<ExtraVO> listExtras = new ArrayList<>();

	private BigDecimal preco;

	private Boolean existeVoo;

	private Boolean existeOnibus;
	

}
