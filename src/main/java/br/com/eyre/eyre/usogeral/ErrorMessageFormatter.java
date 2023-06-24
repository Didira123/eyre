package br.com.eyre.eyre.usogeral;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorMessageFormatter {

	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<Erro> handle(MethodArgumentNotValidException ex) {
		List<Erro> erros = new ArrayList<>();
		List<FieldError> fieldErros = ex.getBindingResult().getFieldErrors();
		fieldErros.forEach(fe -> erros
				.add(new Erro(fe.getField(), messageSource.getMessage(fe, LocaleContextHolder.getLocale()))));
		return erros;
	}

}
