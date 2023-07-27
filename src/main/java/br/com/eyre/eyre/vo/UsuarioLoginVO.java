package br.com.eyre.eyre.vo;

import java.io.Serializable;

import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class UsuarioLoginVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String email;

	private String senha;

}
