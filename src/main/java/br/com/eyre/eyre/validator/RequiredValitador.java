package br.com.eyre.eyre.validator;

import br.com.eyre.eyre.annotations.Required;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RequiredValitador implements ConstraintValidator<Required, Object> {

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		return false;
	}

}
