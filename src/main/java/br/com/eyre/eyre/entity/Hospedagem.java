package br.com.eyre.eyre.entity;

import java.math.BigDecimal;
import java.util.List;

import br.com.eyre.eyre.enums.QuartoEnum;
import br.com.eyre.eyre.vo.HospedagemVO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "hospedagem")
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class Hospedagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "titulo")
	private String titulo;

	@Column(name = "descricao")
	private String descricao;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "tipo_quarto")
	private QuartoEnum tipoQuarto;

	@Column(name = "descricao_quarto")
	private String descricaoQuarto;

	@Column(name = "quantidade_reservas")
	private Integer quantidadeReservas;

	@OneToMany(mappedBy = "hospedagem")
	private List<HospedagemTransporte> listTransportes;

	@OneToMany(mappedBy = "hospedagem")
	private List<HospedagemExtra> listExtras;

	@OneToMany(mappedBy = "hospedagem")
	private List<HospedagemMidia> listImagens;

	@OneToMany(mappedBy = "hospedagem")
	private List<HospedagemProximidade> listProximidades;

	@Column(name = "email")
	private String email;

	@Column(name = "telefone")
	private String telefone;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	@OneToMany(mappedBy = "hospedagem")
	private List<Avaliacao> listAvaliacoes;

	@Column(name = "preco")
	private BigDecimal preco;

	public Hospedagem() {
	}

	public Hospedagem(Long id) {
		setId(id);
	}

	public HospedagemVO toVO() {
		HospedagemVO vo = new HospedagemVO();
		vo.setId(getId());
		vo.setTitulo(getTitulo());
		vo.setDescricao(getDescricao());
		vo.setTipoQuarto(getTipoQuarto());
		vo.setDescricaoQuarto(getDescricaoQuarto());
		vo.setQuantidadeReservas(getQuantidadeReservas());
		vo.setEmail(getEmail());
		vo.setTelefone(getTelefone());
		vo.setEndereco(getEndereco().toVO());
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
		Hospedagem other = (Hospedagem) obj;
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
