package br.com.eyre.eyre.service.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.eyre.eyre.entity.Hospedagem;
import br.com.eyre.eyre.enums.DiaEnum;
import br.com.eyre.eyre.enums.EnderecoEnum;

public interface HospedagemRepository extends JpaRepository<Hospedagem, Long> {

	@Query(value = "SELECT * FROM Hospedagem h INNER JOIN h.endereco he INNER JOIN h.listTransportes lt INNER JOIN lt.transporte t "
			+ "INNER JOIN t.listTransporteEnderecos lte INNER JOIN lte.endereco et "
			+ "WHERE (he.estado=:estadoChegada AND he.cidade=:cidadeChegada) " // Endereco Chegada (Hospedagem)
			+ "AND (lte.tipoEndereco=:saida AND (et.estado=:estadoSaida AND et.cidade=:cidadeSaida)) " // Endereco Saída
																										// (Transporte)
			+ "" // TODO adicionar dias da semana de trabalho dos transportes
			+ "AND ((h.preco + t.preco)/1.15<:orcamento) OR (h.preco + t.preco)/0.85>:orcamento))") // Orcamento varia
																									// no máximo 15%
	public List<Hospedagem> findByOrcamentoAndEnderecosAndDatas(BigDecimal orcamento, String estadoSaida,
			String cidadeSaida, String estadoChegada, String cidadeChegada, DiaEnum diaIda, DiaEnum diaVolta,
			EnderecoEnum saida);

//	h JOIN h.lt JOIN lt.t JOIN t.lte JOIN lte.e WHERE lte.tipoEndereco=:saida; 
//	
//	
//	
//	

}
