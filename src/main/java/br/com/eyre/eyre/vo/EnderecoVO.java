package br.com.eyre.eyre.vo;

import br.com.eyre.eyre.bases.BaseVO;
import br.com.eyre.eyre.entity.Endereco;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class EnderecoVO extends BaseVO<Long> {

	private static final String HIFEN = " - ";

	private static final long serialVersionUID = 1L;

	private String cep;

	private String pais;

	@NotBlank
	private String estado;

	@NotBlank
	private String sigla;

	@NotBlank
	private String cidade;

	private String bairro;

	private String rua;

	private String numero;

	public static String formatEndereco(Endereco e) {
		return "Rua " + e.getRua() + ", " + e.getNumero() + HIFEN + e.getBairro() + HIFEN + e.getCidade() + HIFEN
				+ e.getEstado() + " " + e.getSigla() + HIFEN + e.getCep();
	}

}
