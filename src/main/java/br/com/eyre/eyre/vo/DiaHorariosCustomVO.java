package br.com.eyre.eyre.vo;

import java.util.List;

import br.com.eyre.eyre.bases.BaseVO;
import br.com.eyre.eyre.enums.RotaEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DiaHorariosCustomVO extends BaseVO<Long> {

	private static final long serialVersionUID = 1L;

	private List<TransporteDiaHorarioVO> listHorarios;

	private RotaEnum tipoRota;

}
