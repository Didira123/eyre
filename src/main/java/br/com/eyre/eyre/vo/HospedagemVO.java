package br.com.eyre.eyre.vo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.eyre.eyre.bases.BaseVO;
import br.com.eyre.eyre.enums.QuartoEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class HospedagemVO extends BaseVO<Long> {

	private static final long serialVersionUID = 1L;

	private String titulo;

	private String descricao;

	private QuartoEnum tipoQuarto;

	private String descricaoQuarto;

	private Integer quantidadeReservas;

	private List<TransporteVO> listTransportes = new ArrayList<>();

	private List<ExtraVO> listExtras = new ArrayList<>();

	private List<MidiaVO> listImagens = new ArrayList<>();

	private List<ProximidadeVO> listProximidades = new ArrayList<>();

	private String email;

	private String telefone;

	private EnderecoVO endereco;

	private List<AvaliacaoVO> listAvaliacoes = new ArrayList<>();

	private BigDecimal preco;

	private Boolean existeVoo;

	private Boolean existeOnibus;

	public HospedagemVO() {
	}

	public HospedagemVO(Long id) {
		setId(id);
	}

}
