package br.com.eyre.eyre.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.eyre.eyre.entity.Hospedagem;
import br.com.eyre.eyre.repository.custom.HospedagemRepositoryCustom;

public interface HospedagemRepository extends JpaRepository<Hospedagem, Long>, HospedagemRepositoryCustom{

	@Query(value = "SELECT distinct h FROM Hospedagem h "
			+ " INNER JOIN FETCH h.endereco he "
//			+ " INNER JOIN h.listMidias lm "
//			+ " INNER JOIN lm.midia mid "
			+ " INNER JOIN FETCH h.listTransportes lt "
			+ " INNER JOIN FETCH lt.transporte t "
			+ " INNER JOIN FETCH t.listTransporteEnderecos lte "
			+ " INNER JOIN FETCH t.midia mid2 "
			+ " INNER JOIN FETCH lte.endereco te "
			+ " INNER JOIN FETCH t.listTransporteDias ltd "
			+ " INNER JOIN FETCH ltd.listTransporteDiaHorarios ltdh "
			+ " LEFT JOIN FETCH h.listExtras le "
			+ " LEFT JOIN FETCH le.extra ext "
//			+ " LEFT JOIN h.listProximidades lp "
//			+ " LEFT JOIN lp.proximidade prox "
//			+ " LEFT JOIN prox.foto f "
			+ " WHERE h.id =:id")
	public Optional<Hospedagem> findByIdFetchEnderecoFetchTransportesFetchExtras(
			Long id);

}
