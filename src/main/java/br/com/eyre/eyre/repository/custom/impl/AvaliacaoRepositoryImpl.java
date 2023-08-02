package br.com.eyre.eyre.repository.custom.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.eyre.eyre.entity.Avaliacao;
import br.com.eyre.eyre.repository.custom.AvaliacaoRepositoryCustom;
import br.com.eyre.eyre.vo.filter.AvaliacaoFilterVO;
import br.com.eyre.eyre.vo.filter.AvaliacaoFiltroVO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class AvaliacaoRepositoryImpl implements AvaliacaoRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Avaliacao> findByFilter(AvaliacaoFiltroVO filtro) {
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT a FROM Avaliacao a ");
		builder.append(" INNER JOIN a.hospedagem h ");
		builder.append(" INNER JOIN a.usuario u ");

		setParametersPlace(filtro, builder);

		if (filtro.getOrder() != null) {
			builder.append("ORDER BY a." + filtro.getOrder() + " "
					+ (filtro.getDirection() != null ? filtro.getDirection() : ""));
		}

		Query query = createQueryWithFiltro(filtro, builder);
		if (filtro.getPage() != null && filtro.getPageSize() != null) {
			query.setFirstResult(filtro.getPage() * filtro.getPageSize());
			query.setMaxResults(filtro.getPageSize());
		}
		return query.getResultList();
	}

	public Long countByFilter(AvaliacaoFiltroVO filtro) {
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT count(a.id) FROM Avaliacao a ");
		builder.append(" INNER JOIN a.hospedagem h ");
		builder.append(" INNER JOIN a.usuario u ");

		setParametersPlace(filtro, builder);
		Query query = createQueryWithFiltro(filtro, builder);
		return (Long) query.getSingleResult();
	}

	private void setParametersPlace(AvaliacaoFiltroVO filtro, StringBuilder builder) {
		AvaliacaoFilterVO content = filtro.getContent();
		builder.append(" WHERE 1=1 ");
		if (content.getIdHospedagem() != null) {
			builder.append(" AND (h.id =:idHospedagem) ");
		}
		if (content.getMinNota() != null) {
			builder.append(" AND (a.nota >= :minNota) ");
		}
		if (content.getMaxNota() != null) {
			builder.append(" AND (a.nota <= :maxNota) ");
		}

	}

	private Query createQueryWithFiltro(AvaliacaoFiltroVO filtro, StringBuilder builder) {
		AvaliacaoFilterVO content = filtro.getContent();
		Query query = entityManager.createQuery(builder.toString());
		if (content.getIdHospedagem() != null) {
			query.setParameter("idHospedagem", content.getIdHospedagem());
		}
		if (content.getMinNota() != null) {
			query.setParameter("minNota", content.getMinNota());
		}
		if (content.getMaxNota() != null) {
			query.setParameter("maxNota", content.getMaxNota());
		}
		return query;
	}

}
