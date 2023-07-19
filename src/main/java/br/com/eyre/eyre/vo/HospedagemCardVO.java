package br.com.eyre.eyre.vo;

import java.math.BigDecimal;
import java.util.List;

import br.com.eyre.eyre.enums.QuartoEnum;
import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class HospedagemCardVO {

	private Long id;

	private String titulo;

	private QuartoEnum tipoQuarto;

	private String descricaoQuarto;

	private Integer quantidadeReservas;

	private List<ExtraVO> listExtras;

	private BigDecimal preco;

	private Boolean existeVoo;

	private Boolean existeOnibus;

}
