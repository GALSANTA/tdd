package com.fiscal.app.imposto;

import java.math.BigDecimal;

public class ImpostoOutro implements ImpostoInterface {

    @Override
	public BigDecimal calcularImposto(BigDecimal valor) {
		return new BigDecimal(0.06).multiply(valor);
	}
}