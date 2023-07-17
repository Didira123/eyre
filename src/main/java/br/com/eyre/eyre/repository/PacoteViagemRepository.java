package br.com.eyre.eyre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eyre.eyre.entity.PacoteViagem;
import br.com.eyre.eyre.vo.UsuarioVO;

public interface PacoteViagemRepository extends JpaRepository<PacoteViagem, Long> {

	List<PacoteViagem> findByUsuario(UsuarioVO vo);

	Long countByUsuario(UsuarioVO vo);

}
