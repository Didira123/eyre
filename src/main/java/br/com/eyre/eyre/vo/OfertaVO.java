package br.com.eyre.eyre.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.eyre.eyre.enums.DiaEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class OfertaVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Positive
	private BigDecimal orcamento;

	@NotNull
	private EnderecoVO partida;

	@NotNull
	private EnderecoVO destino;

	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataIda;

	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataVolta;

	private boolean diasAMais;

}
