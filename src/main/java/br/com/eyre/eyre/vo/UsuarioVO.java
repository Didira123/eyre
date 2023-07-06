package br.com.eyre.eyre.vo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import br.com.eyre.eyre.entity.Endereco;
import br.com.eyre.eyre.entity.Imagem;
import br.com.eyre.eyre.entity.Role;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
public class UsuarioVO {

	private Long id;

	private String cpfCnpj;

	private String nome;

	private String email;

	private String senha;

	private LocalDate dataNascimento;

	private Integer telefone;

	private Imagem foto;

	private Role role;

	private Endereco endereco;

	private Boolean ativo;
	
}
