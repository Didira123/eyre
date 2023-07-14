package br.com.eyre.eyre.vo;

import java.time.LocalTime;

import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class TransporteDiaHorarioVO {

	private Long id;

	private TransporteDiaVO transporteDia;

	private LocalTime horarioSaida;
	
	private LocalTime horarioChegada;

}
