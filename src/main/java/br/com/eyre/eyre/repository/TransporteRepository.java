package br.com.eyre.eyre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.eyre.eyre.entity.Transporte;

public interface TransporteRepository extends JpaRepository<Transporte, Long> {
	
	@Query("SELECT t FROM Transporte t "
			+ " INNER JOIN t.listTransporteEnderecos lte WITH lte.tipoEndereco = 1 "
			+ " INNER JOIN lte.endereco e "
			+ " WHERE e.pais = :pais AND e.estado = :estado AND e.cidade = :cidade")
	List<Transporte> findByDestinoWithPaisAndEstadoAndCidade(String pais, String estado, String cidade);

}
