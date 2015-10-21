package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;

public class PrecoPadrao implements Preco {

	@Override
	public BigDecimal calculaPreco(Sessao sessao) {
		return sessao.getPrecoSugerido();
	}

}
