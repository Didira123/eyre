package br.com.eyre.eyre.entity;

import java.util.List;
import java.util.stream.Collectors;

import br.com.eyre.eyre.bases.BaseEntity;
import br.com.eyre.eyre.enums.DiaEnum;
import br.com.eyre.eyre.enums.RotaEnum;
import br.com.eyre.eyre.vo.TransporteDiaVO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "transporte_dia")
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class TransporteDia extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transporte_id")
	private Transporte transporte;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "dia")
	private DiaEnum dia;

	@OneToMany(mappedBy = "transporteDia")
	private List<TransporteDiaHorario> listTransporteDiaHorarios;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "tipo_rota")
	private RotaEnum tipoRota;

	public TransporteDia() {
	}

	public TransporteDia(Long id) {
		setId(id);
	}

	public TransporteDiaVO toVO() {
		TransporteDiaVO vo = new TransporteDiaVO();
		vo.setId(getId());
		vo.setDia(getDia());
		if (getListTransporteDiaHorarios() != null && !getListTransporteDiaHorarios().isEmpty()) {
			vo.setListTransporteDiaHorarios(
					getListTransporteDiaHorarios().stream().map(tdh -> tdh.toVO()).collect(Collectors.toList()));
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
		TransporteDia other = (TransporteDia) obj;
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
