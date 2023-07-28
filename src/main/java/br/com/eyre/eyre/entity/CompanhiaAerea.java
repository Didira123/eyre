package br.com.eyre.eyre.entity;

import java.time.LocalTime;

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

	private static final long serialVersionUID = 1L;

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
//		vo.setType(getDtype());
		vo.setNome(getNome());
		if (getListTransporteEnderecos() != null && getListTransporteEnderecos().size() == 2) {
			TransporteEndereco[] tes = getListTransporteEndereco_Ordenado();
			vo.setLocalSaida(tes[0].getEndereco().toVO());
			vo.setLocalChegada(tes[1].getEndereco().toVO());
		}
		vo.setEscala(getEscala());
		if (getMidia() != null) {
			vo.setMidia(getMidia().toVO());
		}
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
