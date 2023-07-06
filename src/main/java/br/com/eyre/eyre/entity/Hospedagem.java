package br.com.eyre.eyre.entity;

import java.util.List;

import br.com.eyre.eyre.vo.HospedagemVO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

	@Column(name = "descricao_quarto")
	private String descricaoQuarto;

	@Column(name = "quant_reservas")
	private Integer quantidadeReservas;

	@OneToMany(mappedBy = "hospedagem")
	private List<Transporte> listTransportes;

	@OneToMany(mappedBy = "hospedagem")
	private List<Extra> listExtras;

	@OneToMany(mappedBy = "hospedagem")
	private List<Imagem> listImagens;

	@OneToMany(mappedBy = "hospedagem")
	private List<Proximidade> listProximidades;

	@Column(name = "email")
	private String email;

	@Column(name = "telefone")
	private Integer telefone;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	@OneToMany(mappedBy = "hospedagem")
	private List<Avaliacao> listAvaliacoes;

	public Hospedagem() {
	}

	public Hospedagem(Long id) {
		setId(id);
	}

	public HospedagemVO toVO() {
		HospedagemVO vo = new HospedagemVO();
		vo.setId(getId());
		vo.set();
		vo.set();
		vo.set();
		vo.set();
		vo.set();
		vo.set();
		vo.set();

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
