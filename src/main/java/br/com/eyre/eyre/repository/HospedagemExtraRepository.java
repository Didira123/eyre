package br.com.eyre.eyre.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.eyre.eyre.entity.HospedagemExtra;
import br.com.eyre.eyre.enums.ExtraEnum;

public interface HospedagemExtraRepository extends JpaRepository<HospedagemExtra, Long> {
	
	@Query(value = "SELECT he FROM HospedagemExtra he "
			+ " INNER JOIN FETCH he.extra "
			+ " WHERE he.hospedagem.id =:id AND he.tipoExtra=:tipoExtra")
	Set<HospedagemExtra> findByHospedagemAndTipoFetchExtra(Long id, ExtraEnum tipoExtra);

}
