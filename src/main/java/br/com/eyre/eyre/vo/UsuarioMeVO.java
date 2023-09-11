package br.com.eyre.eyre.vo;

import br.com.eyre.eyre.entity.Usuario;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UsuarioMeVO extends UsuarioVO {

	private static final long serialVersionUID = 1L;

	public UsuarioMeVO() {

	}

	public UsuarioMeVO(Usuario usuario) {
		setId(usuario.getId());
		setCpfCnpj(usuario.getCpfCnpj());
		setNome(usuario.getNome());
		setEmail(usuario.getEmail());
		setDataNascimento(usuario.getDataNascimento());
		setTelefone(usuario.getTelefone());
		setFoto(usuario.getFoto().toVO());
		setRole(usuario.getRole().toVO());
		setEndereco(usuario.getEndereco().toVO());
		setAtivo(usuario.isAtivo());
	}

}
