package br.com.eyre.eyre.entity;

import br.com.eyre.eyre.vo.HospedagemTransporteVO;
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
@Table(name = "hospedagem_transporte")
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class HospedagemTransporte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hospedagem_id")
	private Hospedagem hospedagem;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transporte_id")
	private Transporte transporte;
	
	public HospedagemTransporte() {
	}
	public HospedagemTransporte(Long id) {
		setId(id);
	}
	
	public HospedagemTransporteVO toVO() {
		HospedagemTransporteVO vo = new HospedagemTransporteVO();
		vo.setId(getId());
		vo.setHospedagem(getHospedagem().toVO());
		vo.setTransporte(getTransporte().toVO());

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
		HospedagemTransporte other = (HospedagemTransporte) obj;
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
