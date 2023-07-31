package br.com.eyre.eyre.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import br.com.eyre.eyre.bases.BaseAPI;
import br.com.eyre.eyre.entity.Usuario;
import br.com.eyre.eyre.service.UsuarioService;
import br.com.eyre.eyre.vo.UsuarioNovoVO;
import br.com.eyre.eyre.vo.UsuarioVO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioAPI extends BaseAPI<Long, Usuario, UsuarioVO, UsuarioVO, UsuarioService> {

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

}
