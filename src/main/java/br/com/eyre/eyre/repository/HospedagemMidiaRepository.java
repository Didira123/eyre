package br.com.eyre.eyre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.eyre.eyre.entity.HospedagemMidia;

public interface HospedagemMidiaRepository extends JpaRepository<HospedagemMidia, Long> {

	@Query("SELECT hm FROM HospedagemMidia hm INNER JOIN FETCH hm.midia m WHERE hm.hospedagem.id = :id")
	List<HospedagemMidia> findByHospedagem(Long id);

}
