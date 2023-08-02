package br.com.eyre.eyre.vo.filter;

import java.io.Serializable;

import lombok.Data;

@Data
public class AvaliacaoFilterVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idHospedagem;

	private Double minNota;

	private Double maxNota;

}
