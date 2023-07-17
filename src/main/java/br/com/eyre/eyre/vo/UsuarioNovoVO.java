package br.com.eyre.eyre.vo;

import java.time.LocalDate;

import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class UsuarioNovoVO {

	private Long id;

	private String cpfCnpj;

	private String nome;

	private String email;

	private String senha;

	private LocalDate dataNascimento;

	private String telefone;

	private RoleVO role;

	private EnderecoVO endereco;

}
