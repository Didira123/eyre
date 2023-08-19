package br.com.eyre.eyre.vo;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.eyre.eyre.bases.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TransporteDiaHorarioVO extends BaseVO<Long> {

	private static final long serialVersionUID = 1L;

	private TransporteDiaVO transporteDia;

	@JsonFormat(shape = Shape.STRING, pattern = "HH:mm")
	private LocalTime horarioSaida;

	@JsonFormat(shape = Shape.STRING, pattern = "HH:mm")
	private LocalTime horarioChegada;

}
