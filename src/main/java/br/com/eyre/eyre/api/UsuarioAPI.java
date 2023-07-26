package br.com.eyre.eyre.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import br.com.eyre.eyre.entity.Usuario;
import br.com.eyre.eyre.service.UsuarioService;
import br.com.eyre.eyre.vo.UsuarioNovoVO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioAPI {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping(path = { "/" }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@RequestBody @Valid UsuarioNovoVO vo, BindingResult result) {
		try {
			Long idSaved = usuarioService.create(vo, result).getId();
			UriComponents uriComponents = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(idSaved);
			return ResponseEntity.created(uriComponents.toUri()).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}

	@GetMapping(path = { "/{id}" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		Optional<Usuario> optional = usuarioService.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(optional.get().toVO());
		}
		return ResponseEntity.notFound().build();
	}

}
