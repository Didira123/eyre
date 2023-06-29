
package br.com.eyre.eyre.controller;

import java.security.Principal;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.eyre.eyre.entity.Usuario;

@Controller
public class HelloController {

	@GetMapping("/")
	@ResponseBody
	public String hello(@AuthenticationPrincipal Usuario user) {
		return "Olá "+user.getNome()+". Bem vindo a Eyre!";
	}

}
