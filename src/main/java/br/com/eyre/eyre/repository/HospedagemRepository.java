package br.com.eyre.eyre.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.eyre.eyre.entity.Hospedagem;
import br.com.eyre.eyre.enums.DiaEnum;
import br.com.eyre.eyre.enums.EnderecoEnum;
import br.com.eyre.eyre.enums.ExtraEnum;

public interface HospedagemRepository extends JpaRepository<Hospedagem, Long> {

	@Query(value = "SELECT h FROM Hospedagem h "
			+ "	INNER JOIN h.endereco he "
			+ "	INNER JOIN FETCH h.listTransportes lt "
			+ "	INNER JOIN FETCH lt.transporte t "
			+ "	INNER JOIN t.listTransporteEnderecos lte "
			+ "	INNER JOIN lte.endereco et "
			+ "	INNER JOIN t.listTransporteDias ltd "
			+ "	INNER JOIN t.listTransporteDias ltd2 "
			+ " LEFT JOIN FETCH h.listExtras le "
			+ " LEFT JOIN FETCH le.extra ext "
			+ "	WHERE (he.estado=:estadoChegada AND he.cidade=:cidadeChegada) "
			+ "	AND (lte.tipoEndereco=:saida AND (et.estado=:estadoSaida AND et.cidade=:cidadeSaida)) "
			+ "	AND (ltd.dia in(:diasIda) AND ltd2.dia in(:diasVolta)) "
			+ "	AND (((h.preco + t.preco)/1.15<=:orcamento) AND ((h.preco + t.preco)/0.85>=:orcamento)) "
			+ " AND (le.tipoExtra=:extraPrincipal)")
	public List<Hospedagem> findByOrcamentoAndEnderecosAndDatas(BigDecimal orcamento, String estadoSaida,
			String cidadeSaida, String estadoChegada, String cidadeChegada, List<DiaEnum> diasIda,
			List<DiaEnum> diasVolta, EnderecoEnum saida, ExtraEnum extraPrincipal);

	@Query(value = "SELECT h FROM Hospedagem h "
			+ " LEFT JOIN FETCH h.endereco he "
			+ " LEFT JOIN FETCH h.listTransportes lt "
			+ " LEFT JOIN FETCH lt.transporte t "
			+ " LEFT JOIN FETCH t.listTransporteDias ltd "
			+ " LEFT JOIN FETCH ltd.listTransporteDiaHorarios ltdh "
			+ " LEFT JOIN FETCH h.listExtras le "
			+ " LEFT JOIN FETCH le.extra ext "
			+ " LEFT JOIN FETCH h.listMidias lm "
			+ " LEFT JOIN FETCH lm.midia mid "
			+ " LEFT JOIN FETCH h.listProximidades lp "
			+ " LEFT JOIN FETCH lp.proximidade prox "
			+ " LEFT JOIN h.listAvaliacoes la "
			+ " WHERE h.id =:id")
	public Optional<Hospedagem> findByIdFetchEnderecoFetchTransportesFetchExtrasFetchMidiasFetchProximidades(
			Long id);
	
	@Query(value="SELECT count(la.id) FROM Hospedagem h "
			+ " INNER JOIN h.listAvaliacoes la "
			+ " WHERE h.id =:id")
	public Long countAvaliacoesById(Long id);

}
