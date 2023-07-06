package br.com.eyre.eyre.entity;

import java.time.LocalTime;

import br.com.eyre.eyre.vo.CompanhiaAereaVO;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "companhia_aerea")
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
@DiscriminatorValue(value = Transporte.COMPANHIA_AEREA)
public class CompanhiaAerea extends Transporte {

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
	
	public CompanhiaAerea() {	
	}
	
	public CompanhiaAerea(Long id) {	
		setId(id);
	}
	
	public CompanhiaAereaVO toVO() {
		CompanhiaAereaVO vo = new CompanhiaAereaVO();
		vo.setId(getId());
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
		CompanhiaAerea other = (CompanhiaAerea) obj;
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
