//package br.com.eyre.eyre.config.security;
//
//import java.util.ArrayList;
//
//import org.springframework.boot.autoconfigure.security.oauth2.server.servlet.OAuth2AuthorizationServerProperties.Token;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.stereotype.Component;
//
////CLASSE ALTERNATIVA A CLASSE "AUTENTICACAO". ESTA AQUI MOSTRA PARTE DE COMO ERA NO TRAMPO
//
//@Component
//public class AuthenticationProviderImpl implements AuthenticationProvider {
//
//	@Override
//	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//		
//		String username = authentication.getName();
//		String password = authentication.getCredentials().toString();
//		
//		return null;
//	}
//
//	@Override
//	public boolean supports(Class<?> clazz) {
//		return clazz.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
//	}
//	
//	
//	
//}
