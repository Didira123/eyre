package br.com.eyre.eyre.entity;

import br.com.eyre.eyre.bases.BaseEntity;
import br.com.eyre.eyre.enums.EnderecoEnum;
import br.com.eyre.eyre.vo.TransporteEnderecoVO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "transporte_endereco")
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class TransporteEndereco extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transporte_id")
	private Transporte transporte;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "tipo_endereco")
	private EnderecoEnum tipoEndereco;

	public TransporteEndereco() {
	}

	public TransporteEndereco(Long id) {
		setId(id);
	}

	public TransporteEnderecoVO toVO() {
		TransporteEnderecoVO vo = new TransporteEnderecoVO();
		vo.setId(getId());
		vo.setTransporte(getTransporte().toVO());
		vo.setEndereco(getEndereco().toVO());
		vo.setTipoEndereco(getTipoEndereco());

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
		TransporteEndereco other = (TransporteEndereco) obj;
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
