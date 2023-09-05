package br.com.eyre.eyre.vo;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

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

	private List<TransporteCustomDiasVO> voos = new ArrayList<>();

	private List<TransporteCustomDiasVO> onibus = new ArrayList<>();

	private List<ExtraVO> listExtras = new ArrayList<>();

	private List<MidiaVO> listImagens = new ArrayList<>();

	private List<TransporteVO> listTransportes;

	private String email;

	private String telefone;

	@JsonFormat(shape = Shape.STRING, pattern = "HH:mm")
	private LocalTime checkIn;

	@JsonFormat(shape = Shape.STRING, pattern = "HH:mm")
	private LocalTime checkOut;

	private EnderecoVO endereco;

	private List<AvaliacaoVO> listAvaliacoes = new ArrayList<>();

	private BigDecimal preco;

	private Boolean existeVoo;

	private Boolean existeOnibus;

	private HashMap<String, List<ProximidadeVO>> listProximidades = new HashMap<>();

	public HospedagemVO() {
	}

	public HospedagemVO(Long id) {
		setId(id);
	}

}
