package br.com.eyre.eyre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.eyre.eyre.entity.Avaliacao;
import br.com.eyre.eyre.repository.custom.AvaliacaoRepositoryCustom;
import br.com.eyre.eyre.vo.AvaliacoesInfoVO;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long>, AvaliacaoRepositoryCustom {

	@Query(value = "SELECT new br.com.eyre.eyre.vo.AvaliacoesInfoVO(count(a.id), AVG(a.nota)) FROM Avaliacao a "
			+ " WHERE a.hospedagem.id =:id")
	public AvaliacoesInfoVO countAndMediaByHospedagem(Long id);

}
