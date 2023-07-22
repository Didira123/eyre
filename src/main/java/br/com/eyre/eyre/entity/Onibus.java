package br.com.eyre.eyre.entity;

import java.util.List;

import br.com.eyre.eyre.vo.OnibusVO;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "onibus")
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
@DiscriminatorValue(value = Transporte.ONIBUS)
public class Onibus extends Transporte {

	@Column(name = "tipo_assento")
	private String tipoAssento;

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
		vo.setHorarioPartida(getHorarioPartida());
		vo.setHorarioChegada(getHorarioChegada());
		if(getListTransporteEnderecos() != null && getListTransporteEnderecos().size() == 2) {
			List<TransporteEndereco> saidaChegada = getListTransporteEndereco_Ordenado();
			vo.setLocalSaida(saidaChegada.get(0).getEndereco().toVO());
			vo.setLocalChegada(saidaChegada.get(1).getEndereco().toVO());
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
