package br.com.eyre.eyre.vo;

import java.math.BigDecimal;
import java.util.List;

import br.com.eyre.eyre.enums.QuartoEnum;
import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class HospedagemVO {

	private Long id;

	private String titulo;

	private String descricao;

	private QuartoEnum tipoQuarto;

	private String descricaoQuarto;

	private Integer quantidadeReservas;

	private List<TransporteVO> listTransportes;

	private List<ExtraVO> listExtras;

	private List<MidiaVO> listImagens;

	private List<ProximidadeVO> listProximidades;

	private String email;

	private String telefone;

	private EnderecoVO endereco;

	private List<AvaliacaoVO> listAvaliacoes;

	private BigDecimal preco;
	
	private Boolean existeVoo;
	
	private Boolean existeOnibus;

}
