package br.com.eyre.eyre.vo;

import java.time.LocalDateTime;

import br.com.eyre.eyre.bases.BaseVO;
import br.com.eyre.eyre.entity.Hospedagem;
import br.com.eyre.eyre.entity.HospedagemMidia;
import br.com.eyre.eyre.entity.PacoteViagem;
import br.com.eyre.eyre.entity.TransporteEndereco;
import br.com.eyre.eyre.enums.QuartoEnum;
import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class PacoteViagemHistoricoVO extends BaseVO<Long> {

	private static final long serialVersionUID = 1L;

	private String titulo;

	private QuartoEnum tipoQuarto;

	private String email;

	private String telefone;

	private MidiaVO midiaPrincipal;

	private String nomeTransporte;

	private String enderecoSaida;

	private String enderecoChegada;

	private LocalDateTime dataHoraIda;

	private LocalDateTime dataHoraVolta;

	public PacoteViagemHistoricoVO() {
	}

	public PacoteViagemHistoricoVO(Long id) {
		setId(id);
	}

	public PacoteViagemHistoricoVO(PacoteViagem pv) {
		Hospedagem hos = pv.getHospedagem();
		setId(pv.getId());
		setTitulo(hos.getTitulo());
		setTipoQuarto(hos.getTipoQuarto());
		setEmail(hos.getEmail());
		setTelefone(hos.getTelefone());
		setMidiaPrincipal(hos.getListMidias().toArray(new HospedagemMidia[1])[0].getMidia().toVO());
		setNomeTransporte(pv.getTransporte().getNome());
		TransporteEndereco[] lte = pv.getTransporte().getListTransporteEndereco_Ordenado();
		setEnderecoSaida(EnderecoVO.format(lte[0].getEndereco()));
		setEnderecoChegada(EnderecoVO.format(lte[1].getEndereco()));
		setDataHoraIda(pv.getDataHoraIda());
		setDataHoraVolta(pv.getDataHoraVolta());
	}

}
