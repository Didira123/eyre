package br.com.eyre.eyre.entity;

import java.time.LocalDateTime;

import br.com.eyre.eyre.vo.PacoteViagemVO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pacote_viagem")
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class PacoteViagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hospedagem_id")
	private Hospedagem hospedagem;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transporte_id")
	private Transporte transporte;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pagamento_id")
	public Pagamento pagamento;

	@Column(name = "data_hora_ida")
	public LocalDateTime dataHoraIda;

	@Column(name = "data_hora_volta")
	public LocalDateTime dataHoraVolta;

	public PacoteViagem() {
	}

	public PacoteViagem(Long id) {
		setId(id);
	}

	public PacoteViagemVO toVO() {
		PacoteViagemVO vo = new PacoteViagemVO();
		vo.setId(getId());
		vo.setUsuario(getUsuario().toVO());
		vo.setHospedagem(getHospedagem().toVO());
		if (getTransporte() != null) {
			vo.setTransporte(getTransporte().toVO());
		}
		vo.setPagamento(getPagamento().toVO());

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
