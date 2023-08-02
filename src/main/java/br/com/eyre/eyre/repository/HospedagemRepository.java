package br.com.eyre.eyre.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.eyre.eyre.entity.Hospedagem;
import br.com.eyre.eyre.repository.custom.HospedagemRepositoryCustom;

public interface HospedagemRepository extends JpaRepository<Hospedagem, Long>, HospedagemRepositoryCustom{

	@Query(value = "SELECT h FROM Hospedagem h "
			+ " LEFT JOIN FETCH h.endereco he "
			+ " LEFT JOIN FETCH h.listTransportes lt "
			+ " LEFT JOIN FETCH lt.transporte t "
			+ " LEFT JOIN FETCH t.listTransporteEnderecos lte "
			+ " LEFT JOIN FETCH t.listTransporteDias ltd "
			+ " LEFT JOIN ltd.listTransporteDiaHorarios ltdh "
			+ " LEFT JOIN FETCH h.listExtras le "
			+ " LEFT JOIN FETCH le.extra ext "
			+ " LEFT JOIN FETCH h.listMidias lm "
			+ " LEFT JOIN FETCH lm.midia mid "
			+ " LEFT JOIN FETCH h.listProximidades lp "
			+ " LEFT JOIN FETCH lp.proximidade prox "
			+ " WHERE h.id =:id")
	public Optional<Hospedagem> findByIdFetchEnderecoFetchTransportesFetchExtrasFetchMidiasFetchProximidades(
			Long id);

}
