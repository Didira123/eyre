package br.com.eyre.eyre.vo;

import java.time.LocalTime;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CompanhiaAereaVO extends TransporteVO {

	private LocalTime escala;

	private MidiaVO midia;

}
