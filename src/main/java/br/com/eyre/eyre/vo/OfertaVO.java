package br.com.eyre.eyre.vo;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.eyre.eyre.bases.BaseVO;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OfertaVO extends BaseVO<Long> {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Positive
	private BigDecimal orcamento;

	@NotNull
	private EnderecoVO partida;

	@NotNull
	private EnderecoVO destino;

	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
	@NotNull
	private LocalDate dataIda;

	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
	@NotNull
	private LocalDate dataVolta;

}
