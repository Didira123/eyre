package br.com.eyre.eyre.vo;

import java.math.BigDecimal;

import br.com.eyre.eyre.enums.TransporteEnum;
import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class TransporteVO {

	private Long id;

	private Integer limitePassageiros;

	private String empresa;

	private TransporteEnum tipoTransporte;

	private BigDecimal preco;

}
