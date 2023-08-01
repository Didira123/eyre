package br.com.eyre.eyre.vo.filter;

import java.io.Serializable;

import lombok.Data;

@Data
public class PacoteViagemFilterVO implements Serializable {

	private Long idUsuario;

	private boolean emAndamento;

	private static final long serialVersionUID = 1L;

}
