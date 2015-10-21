package br.com.caelum.agiletickets.models;

import br.com.caelum.agiletickets.domain.precos.Preco;
import br.com.caelum.agiletickets.domain.precos.PrecoBalletOrquestra;
import br.com.caelum.agiletickets.domain.precos.PrecoCinemaShow;
import br.com.caelum.agiletickets.domain.precos.PrecoPadrao;

public enum TipoDeEspetaculo {
	
	CINEMA(new PrecoCinemaShow()),
	SHOW(new PrecoCinemaShow()),
	TEATRO(new PrecoPadrao()),
	BALLET(new PrecoBalletOrquestra()),
	ORQUESTRA(new PrecoBalletOrquestra());
	
	private Preco preco;

	private TipoDeEspetaculo(Preco preco) {
		this.preco = preco;
	}
	
	public Preco getPreco() {
		return preco;
	}
	
}
