package com.fiscal.app;

import com.fiscal.app.imposto.ImpostoConsultoria;
import com.fiscal.app.imposto.ImpostoInterface;
import com.fiscal.app.imposto.ImpostoOutro;
import com.fiscal.app.imposto.ImpostoTreinamento;

/**
 * Servico Creator.
 * 
 * @author Fernando Marques.
 *
 */

public enum TipoServico {
    
        CONSULTORIA {
			@Override
			public ImpostoInterface imposto() {
				return new ImpostoConsultoria();
			}
	},
        TREINAMENTO {
			@Override
			public ImpostoInterface imposto() {
				return new ImpostoTreinamento();
			}
	},
        OUTRO {
			@Override
			public ImpostoInterface imposto() {
				return new ImpostoOutro();
			}
    };

	public abstract ImpostoInterface imposto();
}
