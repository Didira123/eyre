package br.com.eyre.eyre.vo;

import java.time.LocalDate;

import br.com.eyre.eyre.bases.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UsuarioVO extends BaseVO<Long> {

	private static final long serialVersionUID = 1L;

	private String cpfCnpj;

	private String nome;

	private String email;

	private LocalDate dataNascimento;

	private String telefone;

	private MidiaVO foto;

	private RoleVO role;

	private EnderecoVO endereco;

	private boolean ativo;

}
