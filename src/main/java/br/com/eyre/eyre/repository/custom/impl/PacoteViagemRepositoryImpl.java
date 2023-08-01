package br.com.eyre.eyre.repository.custom.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.eyre.eyre.entity.PacoteViagem;
import br.com.eyre.eyre.enums.MidiaEnum;
import br.com.eyre.eyre.repository.custom.PacoteViagemRepositoryCustom;
import br.com.eyre.eyre.vo.filter.PacoteViagemFilterVO;
import br.com.eyre.eyre.vo.filter.PacoteViagemFiltroVO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class PacoteViagemRepositoryImpl implements PacoteViagemRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	public List<PacoteViagem> findByFilter(PacoteViagemFiltroVO filtro) {
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT pv FROM PacoteViagem pv ");
		builder.append(" INNER JOIN FETCH pv.hospedagem h ");
		builder.append(" INNER JOIN FETCH pv.transporte t ");
		builder.append(" INNER JOIN FETCH t.listTransporteEnderecos lte ");
		builder.append(" INNER JOIN FETCH lte.endereco et ");
		builder.append(" INNER JOIN FETCH h.listMidias lm ");
		builder.append(" INNER JOIN lm.midia m WITH m.tipoMidia=:midiaPrincipal ");

		setParametersPlace(filtro, builder);

		if (filtro.getOrder() != null) {
			builder.append("ORDER BY pv." + filtro.getOrder() + " "
					+ (filtro.getDirection() != null ? filtro.getDirection() : ""));
		}

		Query query = createQueryWithFiltro(filtro, builder);
		if (filtro.getPage() != null && filtro.getPageSize() != null) {
			query.setFirstResult(filtro.getPage() * filtro.getPageSize());
			query.setMaxResults(filtro.getPageSize());
		}
		return query.getResultList();
	}

	public Long countByFilter(PacoteViagemFiltroVO filtro) {
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT count(pv.id) FROM PacoteViagem pv ");
		builder.append(" INNER JOIN pv.hospedagem h ");
		builder.append(" INNER JOIN pv.transporte t ");
		builder.append(" INNER JOIN t.listTransporteEnderecos lte ");
		builder.append(" INNER JOIN lte.endereco et ");
		builder.append(" INNER JOIN h.listMidias lm ");
		builder.append(" INNER JOIN lm.midia m WITH m.tipoMidia=:midiaPrincipal ");

		setParametersPlace(filtro, builder);
		Query query = createQueryWithFiltro(filtro, builder);
		return (Long) query.getSingleResult();
	}

	private void setParametersPlace(PacoteViagemFiltroVO filtro, StringBuilder builder) {
		PacoteViagemFilterVO content = filtro.getContent();
		builder.append(" WHERE 1=1 ");
		if (content.getIdUsuario() != null) {
			builder.append(" AND (pv.usuario.id = :idUsuario) ");
		}

		if (content.isEmAndamento()) {
			builder.append(" AND (:dataAtual BETWEEN pv.dataHoraIda AND pv.dataHoraVolta) ");
		}

	}

	private Query createQueryWithFiltro(PacoteViagemFiltroVO filtro, StringBuilder builder) {
		PacoteViagemFilterVO content = filtro.getContent();
		Query query = entityManager.createQuery(builder.toString());
		query.setParameter("midiaPrincipal", MidiaEnum.FOTO_PRINCIPAL);
		if (content.getIdUsuario() != null) {
			query.setParameter("idUsuario", content.getIdUsuario());
		}
		if (content.isEmAndamento()) {
			query.setParameter("dataAtual", LocalDateTime.now());
		}
		return query;
	}

}
