package br.com.eyre.eyre.entity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.eyre.eyre.enums.QuartoEnum;
import br.com.eyre.eyre.vo.HospedagemCustomProximidadeVO;
import br.com.eyre.eyre.vo.HospedagemVO;
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
	private Set<HospedagemTransporte> listTransportes;

	@OneToMany(mappedBy = "hospedagem")
	private Set<HospedagemExtra> listExtras;

	@OneToMany(mappedBy = "hospedagem")
	private Set<HospedagemMidia> listMidias;

	@OneToMany(mappedBy = "hospedagem")
	private Set<HospedagemProximidade> listProximidades;

	@Column(name = "email")
	private String email;

	@Column(name = "telefone")
	private String telefone;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	@OneToMany(mappedBy = "hospedagem")
	private Set<Avaliacao> listAvaliacoes;

	@Column(name = "preco")
	private BigDecimal preco;

	public Hospedagem() {
	}

	public Hospedagem(Long id) {
		setId(id);
	}

	public HospedagemVO toVO() {
		HospedagemVO vo = new HospedagemVO(this);
//		vo.setId(getId());
//		vo.setTitulo(getTitulo());
//		vo.setDescricao(getDescricao());
//		vo.setTipoQuarto(getTipoQuarto());
//		vo.setDescricaoQuarto(getDescricaoQuarto());
//		vo.setQuantidadeReservas(getQuantidadeReservas());
//		if (getListTransportes() != null && !getListTransportes().isEmpty()) {
//			vo.setListTransportes(
//					getListTransportes().stream().map(ht -> ht.getTransporte().toVO()).collect(Collectors.toList()));
//		}
//		if (getListExtras() != null && !getListExtras().isEmpty()) {
//			vo.setListExtras(getListExtras().stream().map(e -> e.getExtra().toVO()).collect(Collectors.toList()));
//		}
//		if (getListMidias() != null && !getListMidias().isEmpty()) {
//			vo.setListImagens(getListMidias().stream().map(m -> m.getMidia().toVO()).collect(Collectors.toList()));
//		}
//		if (getListProximidades() != null && !getListTransportes().isEmpty()) {
//			vo.setListProximidades(getListProximidades().stream().map(prox -> prox.getProximidade().toVO())
//					.collect(Collectors.toList()));
//		}
//		vo.setEmail(getEmail());
//		vo.setTelefone(getTelefone());
//		if (getEndereco() != null) {
//			vo.setEndereco(getEndereco().toVO());
//		}
//		if (getListAvaliacoes() != null && !getListAvaliacoes().isEmpty()) {
//			vo.setListAvaliacoes(getListAvaliacoes().stream().map(a -> a.toVO()).collect(Collectors.toList()));
//		}
//		vo.setPreco(getPreco());

		return vo;
	}

	public HospedagemVO toCardVO() {
		HospedagemVO vo = new HospedagemVO();
		vo.setId(getId());
		vo.setTitulo(getTitulo());
		vo.setTipoQuarto(getTipoQuarto());
		vo.setDescricaoQuarto(getDescricaoQuarto());
		vo.setListExtras(getListExtras().stream().map(e -> e.getExtra().toVO()).collect(Collectors.toList()));
		vo.setQuantidadeReservas(getQuantidadeReservas());
		vo.setPreco(getPreco());
		existeTiposTransportes(vo); // verifica "existeVoo" e "existeOnibus"
		return vo;
	}

	private void existeTiposTransportes(HospedagemVO vo) {
		vo.setExisteVoo(false);
		vo.setExisteOnibus(false);
		if (getListTransportes() != null && !getListTransportes().isEmpty()) {
			List<Integer> listDtypes = getListTransportes().stream().map(ht -> {
				return (ht.getTransporte() instanceof Onibus) ? 1 : 0;
			}).collect(Collectors.toList());
			int cont = 0;
			for (; cont < listDtypes.size(); cont++) {
				if (listDtypes.get(cont) == 0) {
					vo.setExisteVoo(true);
					break;
				}
			}
			if (cont != 0 || (cont == 0 && listDtypes.size() != 1 && !listDtypes.isEmpty())) {
				vo.setExisteOnibus(true);
			}
		}
	}

	public HospedagemCustomProximidadeVO toCustomWithProximidadeVO() {
		HospedagemCustomProximidadeVO vo = new HospedagemCustomProximidadeVO();
		vo.setId(getId());
		vo.setHospedagem(toVO());
		List<ProximidadeVO> listProximidades = getListProximidades().stream().map(hp -> hp.getProximidade().toVO())
				.collect(Collectors.toList());
		vo.setProximidadesAsHashMap(listProximidades);
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
