package br.com.eyre.eyre.vo;

import java.util.List;

import br.com.eyre.eyre.enums.DiaEnum;
import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class TransporteDiaVO {

	private Long id;

	private TransporteVO transporte;

	private DiaEnum dia;

	private List<TransporteDiaHorarioVO> listTransporteDiaHorarios;

}
