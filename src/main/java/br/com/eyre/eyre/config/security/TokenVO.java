package br.com.eyre.eyre.config.security;

import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class TokenVO {

	private String token;

	private String type;

	public TokenVO(String token, String type) {
		super();
		this.token = token;
		this.type = type;
	}

}
