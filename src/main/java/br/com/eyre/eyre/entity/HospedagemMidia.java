package br.com.eyre.eyre.entity;

import br.com.eyre.eyre.vo.HospedagemMidiaVO;
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
@Table(name = "hospedagem_midia")
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class HospedagemMidia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hospedagem_id")
	private Hospedagem hospedagem;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "midia_id")
	private Midia midia;

	public HospedagemMidia() {
	}

	public HospedagemMidia(Long id) {
		setId(id);
	}

	public HospedagemMidiaVO toVO() {
		HospedagemMidiaVO vo = new HospedagemMidiaVO();
		vo.setId(getId());
		vo.setHospedagem(getHospedagem().toVO());
		vo.setMidia(getMidia().toVO());

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
		HospedagemMidia other = (HospedagemMidia) obj;
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
