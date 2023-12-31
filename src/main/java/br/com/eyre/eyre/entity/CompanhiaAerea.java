package br.com.eyre.eyre.entity;

import java.time.LocalDate;
import java.util.stream.Collectors;

import br.com.eyre.eyre.vo.CompanhiaAereaVO;
import br.com.eyre.eyre.vo.TransporteCustomDiasVO;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "companhia_aerea")
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
@DiscriminatorValue(value = Transporte.COMPANHIA_AEREA)
public class CompanhiaAerea extends Transporte {

	private static final long serialVersionUID = 1L;

	@Column(name = "escala")
	private Boolean escala;

	public CompanhiaAerea() {
	}

	public CompanhiaAerea(Long id) {
		setId(id);
	}

	public CompanhiaAereaVO toVO() {
		CompanhiaAereaVO vo = new CompanhiaAereaVO();
		vo.setId(getId());
//		vo.setType(getDtype());
		vo.setNome(getNome());
		if (getListTransporteEnderecos() != null && getListTransporteEnderecos().size() == 2) {
			TransporteEndereco[] tes = getListTransporteEndereco_Ordenado();
			vo.setLocalSaida(tes[0].getEndereco().toVO());
			vo.setLocalChegada(tes[1].getEndereco().toVO());
		}
		vo.setEscala(getEscala());
		if (getListTransporteDias() != null && !getListTransporteDias().isEmpty()) {
			vo.setListTransporteDias(
					getListTransporteDias().stream().map(td -> td.toVO()).collect(Collectors.toList()));
		}
		if (getMidia() != null) {
			vo.setMidia(getMidia().toVO());
		}
		vo.setPreco(getPreco());

		return vo;
	}

//	private String nome;
//
//	private List<TransporteDiaVO> listDias;
//
//// ---------Campos de CompanhiaAerea abaixo:
//	
//	private LocalTime escala;
//
//	private MidiaVO imgCompanhiaAerea;
//
//// ---------Campos de Onibus abaixo:
//
//	private MidiaVO imagemPoltrona;
//
//	private String localSaida;
//
//	private String LocalChegada;
//
//	private AssentoEnum tipoPoltrona;

	public TransporteCustomDiasVO toCustomVO(LocalDate dataIda, LocalDate dataVolta, Boolean maisDias) {
		TransporteCustomDiasVO vo = new TransporteCustomDiasVO();
		vo.setNome(getNome());
		if (getListTransporteDias() != null && !getListTransporteDias().isEmpty()) {
			vo.setListDias(TransporteCustomDiasVO.getHashMapDiasHorarios(getListTransporteDias(), dataIda, dataVolta,
					maisDias));
		}
		vo.setEscala(getEscala());
		if (getMidia() != null) {
			vo.setImagemCompanhiaAerea(getMidia().toVO());
		}

		return vo;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompanhiaAerea other = (CompanhiaAerea) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}

}
