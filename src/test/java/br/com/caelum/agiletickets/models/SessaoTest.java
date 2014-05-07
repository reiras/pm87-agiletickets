package br.com.caelum.agiletickets.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SessaoTest {

	private Sessao sessao;

	@Before
	public void setup() {
		this.sessao = new Sessao();
	}	

	@Test
	public void deveVenderSeHaMaisVagasQueRequisitado() throws Exception {
		this.sessao.setTotalIngressos(10);

		Assert.assertTrue(this.sessao.podeReservar(5));
	}

	@Test
	public void naoDeveVenderSeHaMenosVagasQueRequisitado() throws Exception {
		this.sessao.setTotalIngressos(2);

		Assert.assertFalse(this.sessao.podeReservar(3));
	}

	@Test
	public void reservarIngressosDeveDiminuirONumeroDeIngressosDisponiveis()
			throws Exception {
		this.sessao.setTotalIngressos(5);

		this.sessao.reserva(3);
		
		Assert.assertEquals(2, this.sessao.getIngressosDisponiveis().intValue());
	}

	@Test
	public void deveVenderSeHaMesmaQuantidadeDeVagasQueRequisitado() {
		this.sessao.setTotalIngressos(2);

		Assert.assertTrue(this.sessao.podeReservar(2));
	}

}
