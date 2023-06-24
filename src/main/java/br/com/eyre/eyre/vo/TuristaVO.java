package br.com.eyre.eyre.vo;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class TuristaVO {

	private Long id;

	private String nome;

	private String cpf;

	private String senha;

	private String email;

	private LocalDate dataNascimento;

	private String telefone;

	private List<PacoteViagemVO> listPacoteViagens;

}
