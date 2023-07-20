package br.com.eyre.eyre.entity;

import java.time.LocalTime;

import br.com.eyre.eyre.vo.TransporteDiaHorarioVO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "transporte_dia_horario")
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class TransporteDiaHorario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transporte_dia_id")
	private TransporteDia transporteDia;

	@Column(name = "horario_saida")
	private LocalTime horarioSaida;

	@Column(name = "horario_chegada")
	private LocalTime horarioChegada;

	public TransporteDiaHorario() {
	}

	public TransporteDiaHorario(Long id) {
		setId(id);
	}

	public TransporteDiaHorarioVO toVO() {
		TransporteDiaHorarioVO vo = new TransporteDiaHorarioVO();
		vo.setId(getId());
		if (getTransporteDia() != null) {
			vo.setTransporteDia(getTransporteDia().toVO());
		}
		vo.setHorarioSaida(getHorarioSaida());
		vo.setHorarioChegada(getHorarioChegada());

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
		TransporteDiaHorario other = (TransporteDiaHorario) obj;
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
