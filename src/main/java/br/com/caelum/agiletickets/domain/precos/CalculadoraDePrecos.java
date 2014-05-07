package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;
import br.com.caelum.agiletickets.models.TipoDeEspetaculo;

public class CalculadoraDePrecos {

	private static final double PORCENTAGEM_DE_5 = 0.05;

	private static final double PORCENTAGEM_DE_10 = 0.10;

	private static final double PORCENTAGEM_DE_20 = 0.20;

	private static final double PORCENTAGEM_DE_50 = 0.50;

	public static BigDecimal calcula(Sessao sessao, Integer quantidade) {
		BigDecimal preco = sessao.getPreco();

		String tipoEspetaculo = sessao.getEspetaculo().getTipo().toString();
		Double percentualDeIngressosDisponiveis = sessao
				.getPercentualDeIngressosDisponiveis();

		if (tipoEspetaculo.equals(TipoDeEspetaculo.CINEMA)
				|| tipoEspetaculo.equals(TipoDeEspetaculo.SHOW)) {

			// quando estiver acabando os ingressos...
			preco = calculaCinemaEShow(sessao, percentualDeIngressosDisponiveis);

		} else if (tipoEspetaculo.equals(TipoDeEspetaculo.BALLET)) {

			preco = calculaBalletEOrquestra(sessao,
					percentualDeIngressosDisponiveis);

		} else if (tipoEspetaculo.equals(TipoDeEspetaculo.ORQUESTRA)) {

			preco = calculaBalletEOrquestra(sessao,
					percentualDeIngressosDisponiveis);

		}

		return preco.multiply(BigDecimal.valueOf(quantidade));
	}

	private static BigDecimal calculaBalletEOrquestra(Sessao sessao,
			Double percentualDeIngressosDisponiveis) {
		BigDecimal preco;
		if (percentualDeIngressosDisponiveis <= PORCENTAGEM_DE_50) {

			preco = sessao.getPreco().add(
					sessao.getPreco().multiply(
							BigDecimal.valueOf(PORCENTAGEM_DE_20)));

		} else {

			preco = sessao.getPreco();

		}

		if (sessao.getDuracaoEmMinutos() > 60) {

			preco = preco.add(sessao.getPreco().multiply(
					BigDecimal.valueOf(PORCENTAGEM_DE_10)));

		}
		return preco;
	}

	private static BigDecimal calculaCinemaEShow(Sessao sessao,
			Double percentualDeIngressosDisponiveis) {
		BigDecimal preco;
		if (percentualDeIngressosDisponiveis <= PORCENTAGEM_DE_5) {

			preco = sessao.getPreco().add(
					sessao.getPreco().multiply(
							BigDecimal.valueOf(PORCENTAGEM_DE_10)));

		} else {

			preco = sessao.getPreco();

		}
		return preco;
	}

}