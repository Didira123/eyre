package br.com.eyre.eyre.entity;

import br.com.eyre.eyre.bases.BaseEntity;
import br.com.eyre.eyre.vo.RoleVO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "role")
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class Role extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	public static final Long USUARIO_SUDO = 0l;
	public static final Long USUARIO_COMUM = 1l;

	@Column(name = "nome")
	private String nome;

	public Role() {

	}

	public Role(Long id) {
		setId(id);
	}

	public RoleVO toVO() {
		RoleVO vo = new RoleVO();
		vo.setId(getId());
		vo.setNome(getNome());

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
		Role other = (Role) obj;
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
