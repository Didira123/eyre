package br.com.eyre.eyre.repository.custom.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.eyre.eyre.entity.Hospedagem;
import br.com.eyre.eyre.enums.EnderecoEnum;
import br.com.eyre.eyre.enums.ExtraEnum;
import br.com.eyre.eyre.enums.MidiaEnum;
import br.com.eyre.eyre.enums.RotaEnum;
import br.com.eyre.eyre.repository.custom.HospedagemRepositoryCustom;
import br.com.eyre.eyre.vo.OfertaVO;
import br.com.eyre.eyre.vo.filter.HospedagemFiltroVO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class HospedagemRepositoryImpl implements HospedagemRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Hospedagem> findByFilter(HospedagemFiltroVO filtro) {
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT distinct (h) FROM Hospedagem h ");
		builder.append(" INNER JOIN FETCH h.endereco he ");
		builder.append(" INNER JOIN FETCH h.listMidias lm ");
		builder.append(" INNER JOIN lm.midia m WITH m.tipoMidia=:midiaPrincipal ");
		builder.append(" INNER JOIN FETCH h.listTransportes lt ");
		builder.append(" INNER JOIN FETCH lt.transporte t ");
		builder.append(" INNER JOIN t.listTransporteEnderecos lte ");
		builder.append(" INNER JOIN lte.endereco et ");
		builder.append(" INNER JOIN t.listTransporteDias ltd WITH ltd.tipoRota =:rotaIda ");
		builder.append(" INNER JOIN t.listTransporteDias ltd2 WITH ltd.tipoRota =:rotaVolta ");
		builder.append(" LEFT JOIN h.listExtras le WITH le.tipoExtra=:extraPrincipal ");
		builder.append(" LEFT JOIN le.extra ext ");

		setParametersPlace(filtro, builder);

		if (filtro.getOrder() != null) {
			builder.append("ORDER BY h." + filtro.getOrder() + " "
					+ (filtro.getDirection() != null ? filtro.getDirection() : ""));
		}

		Query query = createQueryWithFiltro(filtro, builder);
		if (filtro.getPage() != null && filtro.getPageSize() != null) {
			query.setFirstResult(filtro.getPage() * filtro.getPageSize());
			query.setMaxResults(filtro.getPageSize());
		}
		return query.getResultList();
	}

	public Long countByFilter(HospedagemFiltroVO filtro) {
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT count(distinct h.id) FROM Hospedagem h ");
		builder.append(" INNER JOIN h.endereco he ");
		builder.append(" INNER JOIN h.listMidias lm ");
		builder.append(" INNER JOIN lm.midia m WITH m.tipoMidia=:midiaPrincipal ");
		builder.append(" INNER JOIN h.listTransportes lt ");
		builder.append(" INNER JOIN lt.transporte t ");
		builder.append(" INNER JOIN lt.transporte t2 ");
		builder.append(" INNER JOIN t.listTransporteEnderecos lte ");
		builder.append(" INNER JOIN lte.endereco et ");
		builder.append(" INNER JOIN t.listTransporteDias ltd WITH ltd.tipoRota =:rotaIda ");
		builder.append(" INNER JOIN t.listTransporteDias ltd2 WITH ltd.tipoRota =:rotaVolta ");
		builder.append(" LEFT JOIN h.listExtras le WITH le.tipoExtra=:extraPrincipal ");
		builder.append(" LEFT JOIN le.extra ext ");

		setParametersPlace(filtro, builder);
		Query query = createQueryWithFiltro(filtro, builder);
		return (Long) query.getSingleResult();
	}

	private void setParametersPlace(HospedagemFiltroVO filtro, StringBuilder builder) {
		OfertaVO content = filtro.getContent();
		builder.append(" WHERE 1=1 ");
		builder.append(" AND (he.estado=:estadoChegada AND he.cidade=:cidadeChegada) ");
		if (content.getPartida() != null) {
			builder.append(" AND (lte.tipoEndereco=:saida AND (et.estado=:estadoSaida AND et.cidade=:cidadeSaida)) ");
		}
		if (content.getDataIda() != null && content.getDataVolta() != null) {
			if (content.isDiasAMais()) {
				builder.append(" AND (ltd.dia in(:diasIda) AND ltd2.dia in(:diasVolta)) ");
			} else {
				builder.append(" AND (ltd.dia =:diaIda AND ltd2.dia =:diaVolta) ");
			}
		}
		if (content.getOrcamento() != null) {
			builder.append(" AND (((h.preco + t.preco + t2.preco)/1.15<=:orcamento) AND ((h.preco + t.preco + t2.preco)/0.85>=:orcamento)) ");
		}

	}

	private Query createQueryWithFiltro(HospedagemFiltroVO filtro, StringBuilder builder) {
		OfertaVO content = filtro.getContent();
		Query query = entityManager.createQuery(builder.toString());
		query.setParameter("extraPrincipal", ExtraEnum.SERVIÇO_PRINCIPAL);
		query.setParameter("rotaIda", RotaEnum.IDA);
		query.setParameter("rotaVolta", RotaEnum.VOLTA);
		query.setParameter("midiaPrincipal", MidiaEnum.FOTO_PRINCIPAL);
		query.setParameter("estadoChegada", content.getDestino().getEstado());
		query.setParameter("cidadeChegada", content.getDestino().getCidade());
		if (content.getPartida() != null) {
			query.setParameter("saida", EnderecoEnum.SAIDA);
			query.setParameter("estadoSaida", content.getPartida().getEstado());
			query.setParameter("cidadeSaida", content.getPartida().getCidade());
		}
		if (content.getDataIda() != null && content.getDataVolta() != null) {
			if (content.isDiasAMais()) {
				query.setParameter("diasIda", OfertaVO.getDiaAntesAtualEDepois(content.getDataIda()));
				query.setParameter("diasVolta", OfertaVO.getDiaAntesAtualEDepois(content.getDataVolta()));
			} else {
				query.setParameter("diaIda", content.getDataIda());
				query.setParameter("diaVolta", content.getDataVolta());
			}
		}
		if (content.getOrcamento() != null) {
			query.setParameter("orcamento", content.getOrcamento());
		}
		return query;
	}

}
