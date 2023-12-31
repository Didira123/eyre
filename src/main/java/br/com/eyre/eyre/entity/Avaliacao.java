package br.com.eyre.eyre.entity;

import br.com.eyre.eyre.bases.BaseEntity;
import br.com.eyre.eyre.vo.AvaliacaoVO;
import jakarta.persistence.Column;
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
@Table(name = "avaliacao")
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class Avaliacao extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hospedagem_id")
	private Hospedagem hospedagem;

	@Column(name = "texto")
	private String texto;

	@Column(name = "nota")
	private Double nota;

	public Avaliacao() {
	}

	public Avaliacao(Long id) {
		setId(id);
	}

	public AvaliacaoVO toVO() {
		AvaliacaoVO vo = new AvaliacaoVO();
		vo.setId(getId());
		if (getUsuario() != null) {
			vo.setUsuario(getUsuario().toVO());
		}
		if (getHospedagem() != null) {
			vo.setHospedagem(getHospedagem().toTinyVO());
		}
		vo.setTexto(getTexto());
		vo.setNota(getNota());

		return vo;
	}

	public AvaliacaoVO toSmallVO() {
		AvaliacaoVO vo = new AvaliacaoVO();
		vo.setId(getId());
		if (getUsuario() != null) {
			vo.setUsuario(getUsuario().toTinyVO());
		}
		vo.setTexto(getTexto());
		vo.setNota(getNota());

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
		Avaliacao other = (Avaliacao) obj;
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
