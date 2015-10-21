package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;

public class PrecoBalletOrquestra implements Preco {
	
	@Override
	public BigDecimal calculaPreco(Sessao sessao) {
		BigDecimal preco = sessao.getPrecoSugerido();
		
		if(sessao.percentualDisponibilidade() <= 0.50) { 
			preco = preco.add(preco.multiply(BigDecimal.valueOf(0.20)));
		}
		
		if(sessao.getDuracaoEmMinutos() > 60){
			preco = preco.add(sessao.getPrecoSugerido().multiply(BigDecimal.valueOf(0.10)));
		}
		return preco;
	}

}
