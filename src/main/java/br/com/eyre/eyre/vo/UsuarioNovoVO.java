package br.com.eyre.eyre.vo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.validation.constraints.Max;
import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class UsuarioNovoVO {

	private String cpfCnpj;

	private String nome;

	private String email;

	@Max(12)
	private String senha;

	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;

	private String telefone;

	private RoleVO role;

	private EnderecoVO endereco;

}
