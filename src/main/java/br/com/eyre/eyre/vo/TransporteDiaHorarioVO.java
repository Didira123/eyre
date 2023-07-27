package br.com.eyre.eyre.vo;

import java.time.LocalTime;

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

	private LocalTime horarioSaida;

	private LocalTime horarioChegada;

}
