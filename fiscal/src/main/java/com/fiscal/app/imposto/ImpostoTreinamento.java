package com.fiscal.app.imposto;

import java.math.BigDecimal;

public class ImpostoTreinamento implements ImpostoInterface {

	@Override
	public BigDecimal calcularImposto(BigDecimal valor) {
		return new BigDecimal(0.15).multiply(valor);
	}
}