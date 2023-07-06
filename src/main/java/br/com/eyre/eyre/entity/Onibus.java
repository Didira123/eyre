package br.com.eyre.eyre.entity;

import java.math.BigDecimal;

import br.com.eyre.eyre.enums.CompanhiaAereaEnum;
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
@DiscriminatorValue(value = Transporte.ONIBUS)
public class Onibus extends Transporte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "tipo_assento")
	private String tipoAssento;
	
	public Onibus() {	
	}
	
	public Onibus(Long id) {	
		setId(id);
	}
	
	public CompanhiaAereaVO toVO() {
		CompanhiaAereaVO vo = new CompanhiaAereaVO();
		vo.setId(getId());
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
		Onibus other = (Onibus) obj;
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
