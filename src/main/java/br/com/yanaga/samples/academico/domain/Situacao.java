package br.com.yanaga.samples.academico.domain;

import com.google.common.collect.ImmutableMap;

import java.math.BigDecimal;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

public enum Situacao {
	REMATRICULA("RMT", v -> v.multiply(new BigDecimal("0.10"))),
	NORMAL("NOR", v -> v.multiply(new BigDecimal("0.15"))),
	CANCELADO("CAN", v -> v.multiply(new BigDecimal("0.15"))),
	DESISTENTE("DES", v -> v.multiply(new BigDecimal("0.15"))),
	TRANCADO("TRA", v -> v.multiply(new BigDecimal("0.15"))),
	REMANEJADO("RMJ", v -> v.multiply(new BigDecimal("0.15"))),
	TRANSFERENCIA_EXTERNA("TRE", v -> v.multiply(new BigDecimal("0.15"))),
	TRANSFERENCIA_INTERNA("TRI", v -> v.multiply(new BigDecimal("0.15")));

	private static final Map<String, Situacao> valueMap;

	static {
		ImmutableMap.Builder<String, Situacao> builder = ImmutableMap.builder();
		Stream.of(values()).forEach(s -> builder.put(s.value, s));
		valueMap = builder.build();
	}

	public static Situacao of(String value) {
		return valueMap.get(value);
	}

	private final String value;

	private final Function<BigDecimal, BigDecimal> desconto;

	private Situacao(String value, Function<BigDecimal, BigDecimal> desconto) {
		this.value = value;
		this.desconto = desconto;
	}

	public String getValue() {
		return value;
	}

	public BigDecimal calcularValor(BigDecimal valor) {
		return desconto.apply(valor);
	}

}
