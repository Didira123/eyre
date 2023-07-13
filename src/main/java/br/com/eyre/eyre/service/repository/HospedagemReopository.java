package br.com.eyre.eyre.service.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.eyre.eyre.entity.Hospedagem;
import br.com.eyre.eyre.enums.EnderecoEnum;
import br.com.eyre.eyre.vo.EnderecoVO;

public interface HospedagemReopository extends JpaRepository<Hospedagem, Long> {
	
	@Query(value = "SELECT * FROM Hospedagem h INNER JOIN h.listTransportes lt INNER JOIN lt.transporte t INNER JOIN t.listTransporteEnderecos lte INNER JOIN lte.endereco e WHERE (lte.tipoEndereco=:saida (AND e.estado=:estadoSaida AND e.cidade=:cidadeSaida)) AND ((h.preco + t.preco)/1.15<:orcamento) OR (h.preco + t.preco)/0.85>:orcamento))")
	public List<Hospedagem> findByOrcamentoAndEnderecosAndDatas(BigDecimal orcamento, String estadoSaida, String cidadeSaida,
			EnderecoVO destino, LocalDate dataIda, LocalDate dataVolta, EnderecoEnum saida);
	
//	h JOIN h.lt JOIN lt.t JOIN t.lte JOIN lte.e WHERE lte.tipoEndereco=:saida; 
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
}
