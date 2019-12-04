package com.calculadora.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@RedisHash("Calculo")
public class Calculo {

	public enum Operacao {
		SOMA, SUBTRACAO, MULTIPLICACAO, DIVISAO
	}
	
	@Id
	private String id;
	private Long arg1;
	private Long arg2;
	private Operacao operacao;
	private Long resultado;

}
