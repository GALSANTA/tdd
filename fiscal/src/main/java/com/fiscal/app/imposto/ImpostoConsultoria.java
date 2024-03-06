package com.fiscal.app.imposto;

import java.math.BigDecimal;

public class ImpostoConsultoria implements ImpostoInterface {

	@Override
	public BigDecimal calcularImposto(BigDecimal valor) {
		return new BigDecimal(0.25).multiply(valor);
	}
}