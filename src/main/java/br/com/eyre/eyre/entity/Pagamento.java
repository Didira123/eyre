package br.com.eyre.eyre.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.eyre.eyre.bases.BaseEntity;
import br.com.eyre.eyre.vo.PagamentoVO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pagamento")
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class Pagamento extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Column(name = "numero_cartao")
	private String numeroCartao;

	@Column(name = "data_expiracao")
	private LocalDate dataExpiracao;

	@Column(name = "cvv")
	private Integer cvv;

	@Column(name = "nome_cartao")
	private String nomeCartao;

	@Column(name = "valor")
	private BigDecimal valor;

	// TODO Pagamento será uma classe PAI (e abstrata) de Cartao, Pix e Boleto
	public Pagamento() {
	}

	public Pagamento(Long id) {
		setId(id);
	}

	public PagamentoVO toVO() {
		PagamentoVO vo = new PagamentoVO();
		vo.setId(getId());
		vo.setCvv(getCvv());
		vo.setNomeCartao(getNomeCartao());
		vo.setNumeroCartao(getNumeroCartao());
		vo.setValor(getValor());
		vo.setDataExpiracao(getDataExpiracao());

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
		Pagamento other = (Pagamento) obj;
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
