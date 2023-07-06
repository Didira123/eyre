package br.com.eyre.eyre.entity;

import java.time.LocalTime;

import br.com.eyre.eyre.vo.TransporteVO;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "transporte")
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(columnDefinition = "dtype", discriminatorType = DiscriminatorType.INTEGER)
public abstract class Transporte {
	
	public static final String COMPANHIA_AEREA = "0";
	public static final String ONIBUS = "1";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "horario_partida")
	private LocalTime horarioPartida;
	
	@Column(name = "horario_retorno")
	private LocalTime horarioRetorno;
	
	@Column(name = "local_saida")
	private Endereco localSaida;
	
	@Column(name = "local_chegada")
	private Endereco localChegada;

//	TODO Não informado o campo de preço do transporte!!!!!!
//	@Column(name = "preco")
//	private BigDecimal preco;
	
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
