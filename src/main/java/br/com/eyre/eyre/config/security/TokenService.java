package br.com.eyre.eyre.config.security;

import java.util.Date;

import org.springframework.security.core.Authentication;

import br.com.eyre.eyre.entity.Usuario;
import io.jsonwebtoken.Jwts;

public class TokenService {

	public String generateToken(Authentication authentication) {
		Usuario logado = (Usuario) authentication.getPrincipal();
		return Jwts.builder()
			.setIssuer("API do BackEnd da Empresa Eyre")
			.setSubject(logado.getId().toString())
			.setIssuedAt(new Date())
			.setExpiration(......)
			.compact()
			.toString();
	}

}
