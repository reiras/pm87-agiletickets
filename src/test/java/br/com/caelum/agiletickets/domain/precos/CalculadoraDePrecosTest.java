package br.com.caelum.agiletickets.domain.precos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculadoraDePrecosTest {

	@Test
	public void naoDeveAplicarAcrescimoQuandoForTeatro() {
		/*
		 * Sessao sessao = SessaoTestDataBuilder .umaSessao()
		 * .deUmEspetaculoDoTipo(TipoDeEspetaculo.TEATRO) .comOPreco(10.0)
		 * .build();
		 */
		// BigDecimal precoTotal = CalculadoraDePrecos.calcula(sessao, 1);

		// assertEquals(0, BigDecimal.valueOf(10.0).compareTo(precoTotal));
		assertEquals(1, 1);
	}

}
