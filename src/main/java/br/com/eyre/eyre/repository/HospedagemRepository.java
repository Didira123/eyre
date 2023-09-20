package br.com.eyre.eyre.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.eyre.eyre.entity.Hospedagem;
import br.com.eyre.eyre.repository.custom.HospedagemRepositoryCustom;

public interface HospedagemRepository extends JpaRepository<Hospedagem, Long>, HospedagemRepositoryCustom{

	@Query(value = "SELECT h FROM Hospedagem h "
			+ " INNER JOIN FETCH h.endereco he "
			+ " INNER JOIN FETCH h.listTransportes lt "
			+ " INNER JOIN FETCH lt.transporte t "
			+ " INNER JOIN FETCH t.listTransporteEnderecos lte "
			+ " INNER JOIN FETCH lte.endereco te "
			+ " INNER JOIN FETCH t.listTransporteDias ltd "
			+ " INNER JOIN FETCH ltd.listTransporteDiaHorarios ltdh "
			+ " INNER JOIN FETCH h.listMidias lm "
			+ " INNER JOIN FETCH lm.midia mid "
			+ " LEFT JOIN FETCH h.listExtras le "
			+ " LEFT JOIN FETCH le.extra ext "
			+ " LEFT JOIN FETCH h.listProximidades lp "
			+ " LEFT JOIN FETCH lp.proximidade prox "
			+ " LEFT JOIN FETCH prox.foto f "
			+ " WHERE h.id =:id")
	public Optional<Hospedagem> findByIdFetchEnderecoFetchTransportesFetchExtrasFetchMidiasFetchProximidades(
			Long id);

}
