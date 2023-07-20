package br.com.eyre.eyre.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.eyre.eyre.vo.UsuarioVO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "usuario")
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class Usuario implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "cpf_cnpj")
	private String cpfCnpj;

	@Column(name = "nome")
	private String nome;

	@Column(name = "email")
	private String email;

	@Column(name = "senha")
	private String senha;

	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;

	@Column(name = "telefone")
	private String telefone;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "midia_id")
	private Midia foto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	private Role role;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	@Column(name = "ativo")
	private Boolean ativo;

	public Usuario() {
	}

	public Usuario(Long id) {
		setId(id);
	}

	public UsuarioVO toVO() {
		UsuarioVO vo = new UsuarioVO();
		vo.setId(getId());
		vo.setCpfCnpj(getCpfCnpj());
		vo.setNome(getNome());
		vo.setEmail(getEmail());
//		vo.setSenha(getSenha());
		vo.setDataNascimento(getDataNascimento());
		vo.setTelefone(getTelefone());
		if (getFoto() != null) {
			vo.setFoto(getFoto().toVO());
		}
		vo.setRole(getRole().toVO());
		if (getEndereco() != null) {
			vo.setEndereco(getEndereco().toVO());
		}
		vo.setAtivo(getAtivo());

		return vo;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		if (getRole() != null) {
			authorities.add(new SimpleGrantedAuthority(getRole().getNome()));
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return getSenha();
	}

	@Override
	public String getUsername() {
		return getCpfCnpj();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return getAtivo();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
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
