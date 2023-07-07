package br.com.eyre.eyre.vo;

import java.util.List;

import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class HospedagemVO {

	private Long id;

	private String titulo;

	private String descricao;

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

}
