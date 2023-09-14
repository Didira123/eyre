package br.com.eyre.eyre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.eyre.eyre.entity.Extra;
import br.com.eyre.eyre.vo.ExtraVO;

public interface ExtraRepository extends JpaRepository<Extra, Long> {

	@Query("Select new br.com.eyre.eyre.vo.ExtraVO(e.id, e.nome, he.tipoExtra) FROM " + " HospedagemExtra he "
			+ " INNER JOIN he.extra e " + " ORDER BY e.nome")
	List<ExtraVO> findAllCustom();

}
