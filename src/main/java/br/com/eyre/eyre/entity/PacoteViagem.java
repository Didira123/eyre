package br.com.eyre.eyre.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import br.com.eyre.eyre.vo.PacoteViagemVO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

	@Column(name = "titulo")
	private String titulo;

	@Column(name = "data_ida")
	private LocalDateTime dataIda;

	@Column(name = "data_volta")
	private LocalDateTime dataVolta;

	@Column(name = "preco")
	private BigDecimal preco;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "turista_id")
	private Turista turista;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hospedagem_id")
	private Hospedagem hospedagem;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pagamento_id")
	private Pagamento pagamento;

	@OneToMany(mappedBy = "pacoteViagem")
	private List<PacoteViagemTurista> listPacoteViagemTuristas;

	public PacoteViagemVO toVO() {
		PacoteViagemVO vo = new PacoteViagemVO();
		vo.setId(getId());
		vo.setTitulo(getTitulo());
		vo.setDataIda(getDataIda());
		vo.setDataVolta(getDataVolta());
		vo.setTurista(getTurista().toVO());
		vo.setHospedagem(getHospedagem().toVO());
		// TODO Definir o VO de retorno dos acompanhantes do PacoteViagem;
//		vo.setListPacoteViagemTuristas(getListPacoteViagemTuristas().stream().map(PacoteViagemTurista::toVO).collect(Collectors.toList()));
		vo.setPagamento(getPagamento().toVO());
		vo.setPreco(getPreco());

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
