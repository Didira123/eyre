package br.com.eyre.eyre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eyre.eyre.entity.PacoteViagem;
import br.com.eyre.eyre.repository.custom.PacoteViagemRepositoryCustom;

public interface PacoteViagemRepository extends JpaRepository<PacoteViagem, Long>, PacoteViagemRepositoryCustom {

}
