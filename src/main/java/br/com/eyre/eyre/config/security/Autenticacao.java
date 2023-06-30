package br.com.eyre.eyre.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eyre.eyre.usogeral.Erro;
import br.com.eyre.eyre.vo.UsuarioLoginVO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class Autenticacao {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;

//	@PostMapping(name = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Usuario> login(UriComponentsBuilder uriBuilder) {
//		return ResponseEntity.created(uriBuilder.path("").buildAndExpand("123").toUri()).body(new Usuario());
//	}

	@PostMapping(name = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> login(@RequestBody @Valid UsuarioLoginVO login) {
		
		UsernamePasswordAuthenticationToken dadosLogin = new UsernamePasswordAuthenticationToken(login.getNome(), login.getSenha());
		try {
			Authentication authentication = authenticationManager.authenticate(dadosLogin);
			String token = tokenService.generateToken(authentication);
			return ResponseEntity.ok().build();			
		} catch(AuthenticationException e) {
			return ResponseEntity.badRequest().build();
//					.body(new Erro("N/A", "Dados Inválidos"));
		}
	}

}
