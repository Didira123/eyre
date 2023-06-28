package br.com.eyre.eyre.repository.custom.impl;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class PacoteViagemRepositoryImpl {

	@PersistenceContext
	private EntityManager entityManager;

}
