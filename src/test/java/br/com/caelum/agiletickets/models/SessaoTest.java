package br.com.caelum.agiletickets.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SessaoTest {
	
	private Sessao sessao;
	
	@Before
	public void setUp() {
		sessao = new Sessao();
	}
	
	@Test
	public void deveVenderIngressosSeHaVagas() throws Exception {
		sessao.setTotalIngressos(10);
		
		Assert.assertTrue(sessao.podeReservar(5));
	}

	@Test
	public void naoDeveVenderIngressoSenaoHaVagas() throws Exception {
		sessao.setTotalIngressos(2);

		Assert.assertFalse(sessao.podeReservar(3));
	}

	@Test
	public void reservarIngressosDeveDiminuirONumeroDeIngressosDisponiveis() throws Exception {
		sessao.setTotalIngressos(5);

		sessao.reserva(3);
		Assert.assertEquals(2, sessao.getIngressosDisponiveis().intValue());
	}
	
	@Test
	public void deveVenderTodosOsIngressosDisponiveisNumaMesmaReserva() {
		sessao.setTotalIngressos(5);
		
		Assert.assertTrue(sessao.podeReservar(5));
	}
	
}
