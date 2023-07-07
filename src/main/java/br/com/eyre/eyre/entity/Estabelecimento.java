package br.com.eyre.eyre.entity;

import br.com.eyre.eyre.vo.EstabelecimentoVO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "estabelecimento")
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class Estabelecimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	private String nome;

	public Estabelecimento() {
	}

	public Estabelecimento(Long id) {
		setId(id);
	}

	public EstabelecimentoVO toVO() {
		EstabelecimentoVO vo = new EstabelecimentoVO();
		vo.setId(getId());
		vo.setNome(getNome());

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
		PacoteViagem other = (PacoteViagem) obj;
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
