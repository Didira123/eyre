package br.com.eyre.eyre.bases;

import java.io.Serializable;

import org.apache.commons.lang3.NotImplementedException;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity<I extends Serializable> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private I id;

	public <B extends BaseVO<I>> B toVO() {
		throw new NotImplementedException(
				"This method from " + getClass().getName() + " must be implemented at the actual subclass.");
	}

}
