package br.com.eyre.eyre.entity;

import br.com.eyre.eyre.bases.BaseEntity;
import br.com.eyre.eyre.enums.MidiaEnum;
import br.com.eyre.eyre.vo.MidiaVO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "midia")
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class Midia extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Column(name = "nome")
	private String nome;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "tipo_midia")
	private MidiaEnum tipoMidia;

	@Column(name = "dados")
	private byte[] dados;

	public Midia() {
	}

	public Midia(Long id) {
		setId(id);
	}

	public MidiaVO toVO() {
		MidiaVO vo = new MidiaVO();
		vo.setId(getId());
		vo.setNome(getNome());
		vo.setTipoMidia(getTipoMidia());
		vo.setDados(getDados());

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
		Midia other = (Midia) obj;
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
