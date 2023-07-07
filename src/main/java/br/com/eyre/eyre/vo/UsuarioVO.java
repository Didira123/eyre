package br.com.eyre.eyre.vo;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UsuarioVO {

	private Long id;

	private String cpfCnpj;

	private String nome;

	private String email;

	private String senha;

	private LocalDate dataNascimento;

	private String telefone;

	private MidiaVO foto;

	private RoleVO role;

	private EnderecoVO endereco;

	private Boolean ativo;

}
