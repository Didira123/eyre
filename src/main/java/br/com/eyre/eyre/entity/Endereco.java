package br.com.eyre.eyre.entity;

import br.com.eyre.eyre.bases.BaseEntity;
import br.com.eyre.eyre.vo.EnderecoVO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "endereco")
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class Endereco extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Column(name = "cep")
	private String cep;

	@Column(name = "pais")
	private String pais;

	@Column(name = "estado")
	private String estado;

	@Column(name = "cidade")
	private String cidade;

	@Column(name = "bairro")
	private String bairro;

	@Column(name = "rua")
	private String rua;

	@Column(name = "numero")
	private String numero;

	public Endereco() {
	}

	public Endereco(Long id) {
		setId(id);
	}

	public EnderecoVO toVO() {
		EnderecoVO vo = new EnderecoVO();
		vo.setId(getId());
		vo.setCep(getCep());
		vo.setPais(getPais());
		vo.setCidade(getCidade());
		vo.setBairro(getBairro());
		vo.setEstado(getEstado());
		vo.setRua(getRua());
		vo.setNumero(getNumero());

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
		Endereco other = (Endereco) obj;
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
