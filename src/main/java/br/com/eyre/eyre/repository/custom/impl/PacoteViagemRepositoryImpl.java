package br.com.eyre.eyre.repository.custom.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.eyre.eyre.entity.PacoteViagem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class PacoteViagemRepositoryImpl {

//	@PersistenceContext
//	private EntityManager entityManager;
//
//	public List<PacoteViagem> findByFilter(PacoteViagemFiltroVO filtro) {
//		StringBuilder builder = new StringBuilder("SELECT pv FROM PacoteViagem pv");
//		builder.append();
//		builder.append();
//		builder.append();
//		builder.append();
//		if (filtro.getOrder() != null) {
//			builder.append(
//					"ORDER BY pv." + filtro.getOrder() + " " + filtro.getDirection() ? filtro.getDirection() : "");
//		}
//		setParametersPlace(filtro, builder);
//		Query query = createQueryWithFiltro(filtro, builder);
//		if (filtro.getPage() != null && filtro.getPageSize() != null) {
//			query.setFirstResult(filtro.getPage());
//			query.setMaxResults(filtro.getPageSize());
//		}
//		return query.getResultList();
//	}
//
//	private Query createQueryWithFiltro(PacoteViagemFiltroVO filtro, StringBuilder builder) {
//		Query query = entityManager.createQuery(builder.toString());
//		if(filtro.getFilter().get...()!= null) {
//			query.setParameter("[..A..]",filtro.getFilter().get...());
//		}
//		...
//		return query;
//	}
//
//	private void setParametersPlace(PacoteViagemFiltroVO filtro, StringBuilder builder) {
//		builder.append(" WHERE 1=1 ");
//		if(filtro.get...()!= null) {
//			builder.append(" AND pv.[...]=:[..A..]");
//		}
//		...
//	}
//	
//	public Long countByFilter(PacoteViagemFiltroVO filtro) {
//		StringBuilder builder = new StringBuilder("SELECT count(pv.id) FROM PacoteViagem pv");
//		builder.append();
//		builder.append();
//		builder.append();
//		builder.append();
//		if (filtro.getOrder() != null) {
//			builder.append(
//					"ORDER BY pv." + filtro.getOrder() + " " + filtro.getDirection() ? filtro.getDirection() : "");
//		}
//		setParametersPlace(filtro, builder);
//		Query query = createQueryWithFiltro(filtro, builder);
//		if (filtro.getPage() != null && filtro.getPageSize() != null) {
//			query.setFirstResult(filtro.getPage());
//			query.setMaxResults(filtro.getPageSize());
//		}
//		return query.getResultList();
//	}

}
