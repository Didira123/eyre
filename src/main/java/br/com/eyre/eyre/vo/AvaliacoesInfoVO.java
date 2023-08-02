package br.com.eyre.eyre.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class AvaliacoesInfoVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long count;

	private Double media;

	public AvaliacoesInfoVO() {
	}

	public AvaliacoesInfoVO(Long count, Double media) {
		setCount(count);
		setMedia(media);
	}

}
