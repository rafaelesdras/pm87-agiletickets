package br.com.caelum.agiletickets.models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.junit.Assert;
import org.junit.Test;

public class EspetaculoTest {

	@Test
	public void deveInformarSeEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertTrue(ivete.Vagas(5));
	}

	@Test
	public void deveInformarSeEhPossivelReservarAQuantidadeExataDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertTrue(ivete.Vagas(6));
	}

	@Test
	public void DeveInformarSeNaoEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertFalse(ivete.Vagas(15));
	}

	@Test
	public void DeveInformarSeEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(4));

		assertTrue(ivete.Vagas(5, 3));
	}

	@Test
	public void DeveInformarSeEhPossivelReservarAQuantidadeExataDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(4));

		assertTrue(ivete.Vagas(10, 3));
	}

	@Test
	public void DeveInformarSeNaoEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(2));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertFalse(ivete.Vagas(5, 3));
	}

	private Sessao sessaoComIngressosSobrando(int quantidade) {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(quantidade * 2);
		sessao.setIngressosReservados(quantidade);

		return sessao;
	}
	
	@Test
	public void deveCriarUmaUnicaSessaoQuandoForOMesmoDia() {
		//Arrange
		Espetaculo depechMode = new Espetaculo();
		LocalDate inicio = new LocalDate(20015, 10, 22);
		LocalDate fim = inicio;
		LocalTime horario = new LocalTime(21, 00);
		
		//Act
		List<Sessao> sessoes = depechMode.criaSessoes(inicio, fim, horario, Periodicidade.DIARIA);
		
		//Assert
		Assert.assertNotNull(sessoes);
		Assert.assertEquals(1, sessoes.size());
		
		Sessao sessao = sessoes.get(0);
		Assert.assertEquals("22/10/15", sessao.getDia());
		Assert.assertEquals("21:00", sessao.getHora());
		Assert.assertEquals(depechMode, sessao.getEspetaculo());
	}
	
	@Test
	public void deveCriarNumeroDeSessoesIgualAoNumeroDiasDoIntervalo() {
		//Arrange
		Espetaculo depechMode = new Espetaculo();
		LocalDate inicio = new LocalDate(2015, 10, 22);
		LocalDate fim = new LocalDate(2015, 10, 24);
		LocalTime horario = new LocalTime(21, 00);
		
		//Act
		List<Sessao> sessoes = depechMode.criaSessoes(inicio, fim, horario, Periodicidade.DIARIA);
		
		//Assert
		Assert.assertNotNull(sessoes);
		Assert.assertEquals(3, sessoes.size());
		
		Sessao sessao1 = sessoes.get(0);
		Assert.assertEquals("22/10/15", sessao1.getDia());
		Assert.assertEquals("21:00", sessao1.getHora());
		Assert.assertEquals(depechMode, sessao1.getEspetaculo());
		
		Sessao sessao2 = sessoes.get(1);
		Assert.assertEquals("23/10/15", sessao2.getDia());
		Assert.assertEquals("21:00", sessao2.getHora());
		Assert.assertEquals(depechMode, sessao2.getEspetaculo());
		
		Sessao sessao3 = sessoes.get(2);
		Assert.assertEquals("24/10/15", sessao3.getDia());
		Assert.assertEquals("21:00", sessao3.getHora());
		Assert.assertEquals(depechMode, sessao3.getEspetaculo());
	}
	
	@Test
	public void deveCriarTresSemanais() {
		//Arrange
		Espetaculo depechMode = new Espetaculo();
		LocalDate inicio = new LocalDate(2011, 1, 9);
		LocalDate fim = new LocalDate(2011, 1, 23);
		LocalTime horario = new LocalTime(17, 00);
		
		//Act
		List<Sessao> sessoes = depechMode.criaSessoes(inicio, fim, horario, Periodicidade.SEMANAL);
		
		//Assert
		Assert.assertNotNull(sessoes);
		Assert.assertEquals(3, sessoes.size());
		
		Sessao sessao1 = sessoes.get(0);
		Assert.assertEquals("09/01/11", sessao1.getDia());
		Assert.assertEquals("17:00", sessao1.getHora());
		Assert.assertEquals(depechMode, sessao1.getEspetaculo());
		
		Sessao sessao2 = sessoes.get(1);
		Assert.assertEquals("16/01/11", sessao2.getDia());
		Assert.assertEquals("17:00", sessao2.getHora());
		Assert.assertEquals(depechMode, sessao2.getEspetaculo());
		
		Sessao sessao3 = sessoes.get(2);
		Assert.assertEquals("23/01/11", sessao3.getDia());
		Assert.assertEquals("17:00", sessao3.getHora());
		Assert.assertEquals(depechMode, sessao3.getEspetaculo());
	}
	
}
