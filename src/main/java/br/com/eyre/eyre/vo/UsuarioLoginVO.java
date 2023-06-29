package br.com.eyre.eyre.vo;

import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class UsuarioLoginVO {

	private String nome;

	private String senha;

	public UsuarioLoginVO() {
	}

//	public UsuarioLoginVO(Long id) {
//		setId(id);
//	}

}
