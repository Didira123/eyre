package br.com.eyre.eyre.entity;

import java.time.LocalDate;
import java.util.List;

import br.com.eyre.eyre.vo.TuristaVO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "turista")
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class Turista {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "senha")
	private String senha;

	@Column(name = "email")
	private String email;

	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;

	@Column(name = "telefone")
	private String telefone;

	@OneToMany(mappedBy = "turista")
	private List<PacoteViagem> listPacoteViagens;

	public Turista() {

	}

	public Turista(Long id) {
		setId(id);
	}

	public TuristaVO toVO() {
		TuristaVO vo = new TuristaVO();
		vo.setId(getId());
		vo.setCpf(getCpf());
		vo.setNome(getNome());
		vo.setEmail(getEmail());
		vo.setSenha(getSenha());
		vo.setTelefone(getTelefone());
		vo.setDataNascimento(getDataNascimento());
//		vo.setListPacoteViagens(getListPacoteViagens().stream().map(PacoteViagem::toVO()).collect(Collectors.toList()));

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
		Turista other = (Turista) obj;
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
