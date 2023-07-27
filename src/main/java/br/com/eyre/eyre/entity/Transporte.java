package br.com.eyre.eyre.entity;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Set;

import br.com.eyre.eyre.bases.BaseEntity;
import br.com.eyre.eyre.enums.EnderecoEnum;
import br.com.eyre.eyre.vo.TransporteVO;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "transporte")
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(columnDefinition = "dtype", discriminatorType = DiscriminatorType.INTEGER)
public abstract class Transporte extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	public static final String COMPANHIA_AEREA = "0";
	public static final String ONIBUS = "1";

//	@Column(name = "dtype")
//	private int dtype;

	@Column(name = "nome")
	private String nome;

	@Column(name = "horario_partida")
	private LocalTime horarioPartida;

	@Column(name = "horario_chegada")
	private LocalTime horarioChegada;

//	@OneToOne(fetch = FetchType.LAZY)
//	@Column(name = "local_saida")
//	private Endereco localSaida;
//
//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "local_chegada")
//	private Endereco localChegada;

	@OneToMany(mappedBy = "transporte")
	private Set<TransporteEndereco> listTransporteEnderecos;

	@OneToMany(mappedBy = "transporte")
	private Set<TransporteDia> listTransporteDias;

	@Column(name = "preco")
	private BigDecimal preco;

	public TransporteEndereco[] getListTransporteEndereco_Ordenado() {
		TransporteEndereco[] array = (TransporteEndereco[]) getListTransporteEnderecos().toArray();
		if (array[0].getTipoEndereco() == EnderecoEnum.CHEGADA) {
			TransporteEndereco te = array[1];
			array[1] = array[0];
			array[0] = te;
		}
		return array;
	}

	public TransporteVO toVO() {
		if (this instanceof CompanhiaAerea) {
			return ((CompanhiaAerea) this).toVO();
		} else if (this instanceof Onibus) {
			return ((Onibus) this).toVO();
		}
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transporte other = (Transporte) obj;
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
