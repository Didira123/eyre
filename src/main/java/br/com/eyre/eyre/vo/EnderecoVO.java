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
	
	@NotBlank
	private String cep;
	
	@NotBlank
	private String pais;

	@NotBlank
	private String estado;

	@NotBlank
	private String sigla;

	@NotBlank
	private String cidade;
	
	@NotBlank
	private String bairro;
	
	@NotBlank
	private String rua;
	
	@NotBlank
	private String numero;

	public static String format(Endereco e) {
		return "Rua " + e.getRua() + ", " + e.getNumero() + HIFEN + e.getBairro() + HIFEN + e.getCidade() + HIFEN
				+ e.getEstado() + " " + e.getSigla() + HIFEN + e.getCep();
	}
	
	public EnderecoVO() {
		
	}
	
	public EnderecoVO(String cidadeEstado) {
		String[] valores = cidadeEstado.split(", ");
		setCidade(valores[0]);
		setEstado(valores[1]);
	}

}
