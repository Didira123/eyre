package br.com.eyre.eyre.vo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.eyre.eyre.bases.BaseVO;
import jakarta.validation.constraints.Max;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UsuarioNovoVO extends BaseVO<Long> {

	private static final long serialVersionUID = 1L;

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
