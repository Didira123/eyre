package br.com.eyre.eyre.vo;

import java.util.ArrayList;
import java.util.List;

import br.com.eyre.eyre.bases.BaseVO;
import br.com.eyre.eyre.enums.DiaEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TransporteDiaVO extends BaseVO<Long> {

	private static final long serialVersionUID = 1L;

	private TransporteVO transporte;

	private DiaEnum dia;

	private List<TransporteDiaHorarioVO> listTransporteDiaHorarios = new ArrayList<>();

}
