package br.com.eyre.eyre.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eyre.eyre.bases.CrudBaseAPI;
import br.com.eyre.eyre.entity.Usuario;
import br.com.eyre.eyre.service.UsuarioService;
import br.com.eyre.eyre.vo.UsuarioNovoVO;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioAPI extends CrudBaseAPI<Long, Usuario, UsuarioNovoVO, UsuarioService> {

	@Autowired
	private UsuarioService usuarioService;

	@Override
	protected UsuarioService getService() {
		return usuarioService;
	}

//	@PostMapping(path = { "/" }, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<?> create(@RequestBody @Valid UsuarioNovoVO vo, BindingResult result) {
//		try {
//			Long idSaved = usuarioService.create(vo, result).getId();
//			UriComponents uriComponents = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//					.buildAndExpand(idSaved);
//			return ResponseEntity.created(uriComponents.toUri()).build();
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseEntity.internalServerError().body(e.getMessage());
//		}
//	}

}
