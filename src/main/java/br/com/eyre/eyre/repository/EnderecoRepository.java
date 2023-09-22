package br.com.eyre.eyre.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.eyre.eyre.entity.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	@Query(value = "SELECT e from Endereco e "
			+ " WHERE e.cep=:cep AND e.rua=:rua AND e.numero=:numero ")
	Optional<Endereco> findByCepAndRuaAndNumero(String cep, String rua, String numero);

}
