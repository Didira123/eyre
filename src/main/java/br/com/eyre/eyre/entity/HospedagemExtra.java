package br.com.eyre.eyre.entity;

import br.com.eyre.eyre.enums.ExtraEnum;
import br.com.eyre.eyre.vo.HospedagemExtraVO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "hospedagem_extra")
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class HospedagemExtra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hospedagem_id")
	private Hospedagem hospedagem;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "extra_id")
	private Extra extra;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "tipo_extra")
	private ExtraEnum tipoExtra;

	public HospedagemExtra() {
	}

	public HospedagemExtra(Long id) {
		setId(id);
	}

	public HospedagemExtraVO toVO() {
		HospedagemExtraVO vo = new HospedagemExtraVO();
		vo.setId(getId());
		vo.setHospedagem(getHospedagem().toVO());
		vo.setExtra(getExtra().toVO());
		vo.setTipoExtra(getTipoExtra());

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
		HospedagemExtra other = (HospedagemExtra) obj;
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
