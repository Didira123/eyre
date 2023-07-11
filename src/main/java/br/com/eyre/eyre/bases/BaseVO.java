package br.com.eyre.eyre.bases;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class BaseVO<I> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

}
