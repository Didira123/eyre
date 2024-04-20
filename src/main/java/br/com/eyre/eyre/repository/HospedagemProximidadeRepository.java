package br.com.eyre.eyre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.eyre.eyre.entity.HospedagemProximidade;

public interface HospedagemProximidadeRepository extends JpaRepository<HospedagemProximidade, Long> {

	@Query("SELECT hp FROM HospedagemProximidade hp INNER JOIN FETCH hp.proximidade p INNER JOIN FETCH p.foto m WHERE hp.hospedagem.id = :id")
	List<HospedagemProximidade> findByHospedagem(Long id);

}
