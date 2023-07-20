package br.com.eyre.eyre.entity;

import br.com.eyre.eyre.enums.ProximidadeEnum;
import br.com.eyre.eyre.vo.ProximidadeVO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "proximidade")
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class Proximidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "tipo_proximidade")
	private ProximidadeEnum tipoProximidade;

	@Column(name = "descricao")
	private String descricao;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "midia_id")
	private Midia foto;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	public Proximidade() {
	}

	public Proximidade(Long id) {
		setId(id);
	}

	public ProximidadeVO toVO() {
		ProximidadeVO vo = new ProximidadeVO();
		vo.setId(getId());
		vo.setNome(getNome());
		vo.setTipoProximidade(getTipoProximidade());
		vo.setDescricao(getDescricao());
		if (getFoto() != null) {
			vo.setFoto(getFoto().toVO());
		}
		if (getEndereco() != null) {
			vo.setEndereco(getEndereco().toVO());
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
		Proximidade other = (Proximidade) obj;
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
