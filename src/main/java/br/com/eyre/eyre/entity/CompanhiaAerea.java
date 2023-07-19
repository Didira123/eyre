package br.com.eyre.eyre.entity;

import java.time.LocalTime;
import java.util.List;

import br.com.eyre.eyre.vo.CompanhiaAereaVO;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "companhia_aerea")
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
@DiscriminatorValue(value = Transporte.COMPANHIA_AEREA)
public class CompanhiaAerea extends Transporte {

	@Column(name = "escala")
	private LocalTime escala;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "midia_id")
	private Midia midia;

	public CompanhiaAerea() {
	}

	public CompanhiaAerea(Long id) {
		setId(id);
	}

	public CompanhiaAereaVO toVO() {
		CompanhiaAereaVO vo = new CompanhiaAereaVO();
		vo.setId(getId());
		vo.setType(getDtype());
		vo.setNome(getNome());
		vo.setHorarioPartida(getHorarioPartida());
		vo.setHorarioChegada(getHorarioChegada());
		List<TransporteEndereco> saidaChegada = getListTransporteEndereco_Ordenado();
		vo.setLocalSaida(saidaChegada.get(0).getEndereco().toVO());
		vo.setLocalChegada(saidaChegada.get(1).getEndereco().toVO());
		vo.setEscala(getEscala());
		vo.setMidia(getMidia().toVO());
		vo.setPreco(getPreco());

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
