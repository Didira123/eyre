package br.com.eyre.eyre.entity;

import br.com.eyre.eyre.vo.PacoteViagemTuristaVO;
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
@Table(name = "pacote_viagem_turista")
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class PacoteViagemTurista {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pacote_viagem_id")
	private PacoteViagem pacoteViagem;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "turista_id")
	private Turista turista;

	public PacoteViagemTuristaVO toVO() {
		PacoteViagemTuristaVO vo = new PacoteViagemTuristaVO();
		vo.setId(getId());
		vo.setPacoteViagem(getPacoteViagem().toVO());
		vo.setTurista(getTurista().toVO());

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
		PacoteViagemTurista other = (PacoteViagemTurista) obj;
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
