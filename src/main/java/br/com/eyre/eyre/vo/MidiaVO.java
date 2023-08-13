package br.com.eyre.eyre.vo;

import java.util.Base64;

import br.com.eyre.eyre.bases.BaseVO;
import br.com.eyre.eyre.enums.MidiaEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MidiaVO extends BaseVO<Long> {

	private static final long serialVersionUID = 1L;

	private String nome;

	private MidiaEnum tipoMidia;

	private String dados;

	public byte[] getByteArrayFrom64() {

		byte[] arrayImage;
		if (dados != null) {
			if (dados.split(",").length > 1) {
				dados = dados.split(",")[1];
			}
			arrayImage = Base64.getDecoder().decode(dados);
		} else {
			arrayImage = new byte[0];
		}
		return arrayImage;

	}

}
