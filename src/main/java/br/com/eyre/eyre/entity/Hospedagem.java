package br.com.eyre.eyre.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.eyre.eyre.bases.BaseEntity;
import br.com.eyre.eyre.enums.QuartoEnum;
import br.com.eyre.eyre.vo.HospedagemCardVO;
import br.com.eyre.eyre.vo.HospedagemCustomProximidadeVO;
import br.com.eyre.eyre.vo.HospedagemVO;
import br.com.eyre.eyre.vo.ProximidadeVO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
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
public class Hospedagem extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

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

	@Column(name = "check_in")
	private LocalTime checkIn;

	@Column(name = "check_out")
	private LocalTime checkOut;

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

	@Override
	public HospedagemVO toVO() {
		// NÂO IMPLEMENTADO (NÂO ESTÀ EM USO!!!! Foi necessário criar o "toCustomVO"
		// para fazer o findById personalizado com data)
		return super.toVO();
	}

	public HospedagemCustomProximidadeVO toCustomVO(LocalDate dataIda, LocalDate dataVolta, Boolean maisDias) {
		HospedagemCustomProximidadeVO vo = new HospedagemCustomProximidadeVO();
//		vo.setId(getId());
		vo.setHospedagem(toFullInnerVO(dataIda, dataVolta, maisDias));
		List<ProximidadeVO> listProximidades = getListProximidades().stream().map(hp -> hp.getProximidade().toSmallVO())
				.collect(Collectors.toList());
		vo.setProximidadesAsHashMap(listProximidades);
		return vo;
	}

	public HospedagemVO toFullInnerVO(LocalDate dataIda, LocalDate dataVolta, Boolean maisDias) {
		HospedagemVO vo = new HospedagemVO();
		vo.setId(getId());
		vo.setTitulo(getTitulo());
		vo.setDescricao(getDescricao());
		vo.setTipoQuarto(getTipoQuarto());
		vo.setDescricaoQuarto(getDescricaoQuarto());
//		if (getListTransportes() != null && !getListTransportes().isEmpty()) {
//			vo.setListTransportes(
//					getListTransportes().stream().map(ht -> ht.getTransporte().toVO()).collect(Collectors.toList()));
//		}
		if (getListTransportes() != null && !getListTransportes().isEmpty()) {
			for (HospedagemTransporte ht : getListTransportes()) {
				if (ht.getTransporte() instanceof CompanhiaAerea) {
					vo.getVoos().add(((CompanhiaAerea) ht.getTransporte()).toCustomVO(dataIda, dataVolta, maisDias));
				} else if (ht.getTransporte() instanceof Onibus) {
					vo.getOnibus().add(((Onibus) ht.getTransporte()).toCustomVO(dataIda, dataVolta, maisDias));
				} else {
					throw new RuntimeException("O transporte de id \"" + ht.getTransporte().getId()
							+ "\" não é válido! (o \"type\" no banco pode estar ausente)");
				}
			}
		}
		if (getListExtras() != null && !getListExtras().isEmpty()) {
			vo.setListExtras(getListExtras().stream().map(e -> e.getExtra().toVO()).collect(Collectors.toList()));
		}
		if (getListMidias() != null && !getListMidias().isEmpty()) {
			vo.setListImagens(getListMidias().stream().map(m -> m.getMidia().toVO()).collect(Collectors.toList()));
		}
		vo.setCheckIn(getCheckIn());
		vo.setCheckOut(getCheckOut());
		if (getEndereco() != null) {
			vo.setEndereco(getEndereco().toVO());
		}
		vo.setPreco(getPreco());
		return vo;
	}

	public HospedagemCardVO toCardVO() {
		HospedagemCardVO vo = new HospedagemCardVO(this);
		return vo;
	}

	@Override
	public HospedagemVO toTinyVO() {
		HospedagemVO vo = new HospedagemVO();
		vo.setId(getId());
		vo.setTitulo(getTitulo());
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
