package br.com.eyre.eyre.entity;

import br.com.eyre.eyre.enums.ExtraEnum;
import br.com.eyre.eyre.vo.ExtraVO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "extra")
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class Extra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "tipo_extra")
	private ExtraEnum tipoExtra;

	public Extra() {
	}

	public Extra(Long id) {
		setId(id);
	}

	public ExtraVO toVO() {
		ExtraVO vo = new ExtraVO();
		vo.setId(getId());
		vo.setNome(getNome());
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
		Extra other = (Extra) obj;
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
