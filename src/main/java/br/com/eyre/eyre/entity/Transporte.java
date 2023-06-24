package br.com.eyre.eyre.entity;

import java.math.BigDecimal;

import br.com.eyre.eyre.enums.TransporteEnum;
import br.com.eyre.eyre.vo.TransporteVO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "transporte")
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class Transporte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "limite_passageiros")
	private Integer limitePassageiros;

	@Column(name = "empresa")
	private String empresa;

	@Column(name = "tipo_transporte")
	private TransporteEnum tipoTransporte;

	@Column(name = "preco")
	private BigDecimal preco;

	public TransporteVO toVO() {
		TransporteVO vo = new TransporteVO();
		vo.setId(getId());
		vo.setTipoTransporte(getTipoTransporte());
		vo.setEmpresa(getEmpresa());
		vo.setLimitePassageiros(getLimitePassageiros());
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
