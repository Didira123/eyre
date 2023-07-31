package br.com.eyre.eyre.entity;

import java.util.stream.Collectors;

import br.com.eyre.eyre.enums.AssentoEnum;
import br.com.eyre.eyre.vo.OnibusVO;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "onibus")
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
@DiscriminatorValue(value = Transporte.ONIBUS)
public class Onibus extends Transporte {

	private static final long serialVersionUID = 1L;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "tipo_assento")
	private AssentoEnum tipoAssento;

	public Onibus() {
	}

	public Onibus(Long id) {
		setId(id);
	}

	public OnibusVO toVO() {
		OnibusVO vo = new OnibusVO();
		vo.setId(getId());
//		vo.setType(getDtype());
		vo.setNome(getNome());
		if (getListTransporteEnderecos() != null && getListTransporteEnderecos().size() == 2) {
			TransporteEndereco[] tes = getListTransporteEndereco_Ordenado();
			vo.setLocalSaida(tes[0].getEndereco().toVO());
			vo.setLocalChegada(tes[1].getEndereco().toVO());
		}
		if (getListTransporteDias() != null && !getListTransporteDias().isEmpty()) {
			vo.setListTransporteDias(
					getListTransporteDias().stream().map(td -> td.toVO()).collect(Collectors.toList()));
		}
		vo.setTipoAssento(getTipoAssento());
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
		Onibus other = (Onibus) obj;
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
