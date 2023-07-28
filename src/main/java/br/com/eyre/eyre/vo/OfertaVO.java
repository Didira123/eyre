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
import lombok.Data;

@Data
public class OfertaVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private BigDecimal orcamento;

	@NotNull
	private EnderecoVO partida;

	@NotNull
	private EnderecoVO destino;

	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataIda;

	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataVolta;

	public static List<DiaEnum> getDiaAntesAtualEDepois(LocalDate data) {
		int codeDia = data.getDayOfWeek().getValue();
		return DiaEnum.getByListCodigo(
				Arrays.asList(codeDia - 1 == 0 ? 7 : codeDia - 1, codeDia, codeDia + 1 == 8 ? 1 : codeDia + 1));
	}

}
