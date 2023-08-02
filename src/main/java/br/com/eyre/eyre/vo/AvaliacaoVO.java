package br.com.eyre.eyre.vo;

import br.com.eyre.eyre.bases.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AvaliacaoVO extends BaseVO<Long> {

	private static final long serialVersionUID = 1L;

	private Long id;

	private UsuarioVO usuario;

	private HospedagemVO hospedagem;

	private String texto;

	private Double nota;

}