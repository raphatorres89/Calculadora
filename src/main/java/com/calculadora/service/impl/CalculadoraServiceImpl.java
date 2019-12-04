package com.calculadora.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calculadora.model.Calculo;
import com.calculadora.model.Calculo.Operacao;
import com.calculadora.repository.CalculoRepository;
import com.calculadora.service.CalculadoraService;

@Service
public class CalculadoraServiceImpl implements CalculadoraService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CalculoRepository calculoRepository;
	
	@Override
	public Long somar(Long arg1, Long arg2) {
		logger.info("Somando {} + {}", arg1, arg2);
		Long resultado = arg1 + arg2;
		calculoRepository.save(this.build(arg1, arg2, Operacao.SOMA, resultado));
		return resultado;
	}

	@Override
	public Long subtrair(Long arg1, Long arg2) {
		logger.info("Subtraindo {} - {}", arg1, arg2);
		Long resultado = arg1 - arg2;
		calculoRepository.save(this.build(arg1, arg2, Operacao.SUBTRACAO, resultado));
		return resultado;
	}

	@Override
	public Long multiplicar(Long arg1, Long arg2) {
		logger.info("Multiplicando {} x {}", arg1, arg2);
		Long resultado = arg1 * arg2;
		calculoRepository.save(this.build(arg1, arg2, Operacao.MULTIPLICACAO, resultado));
		return resultado;
	}

	@Override
	public Long dividir(Long arg1, Long arg2) {
		logger.info("Dividindo {} / {}", arg1, arg2);
		Long resultado = arg1 / arg2;
		calculoRepository.save(this.build(arg1, arg2, Operacao.DIVISAO, resultado));
		return resultado;
	}
	
	private Calculo build(Long arg1, Long arg2, Operacao operacao, Long resultado) {
		return Calculo.builder()
				.arg1(arg1)
				.arg2(arg2)
				.operacao(operacao)
				.resultado(resultado)
				.build();
	}

}
