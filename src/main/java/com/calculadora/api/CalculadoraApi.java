package com.calculadora.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calculadora.service.CalculadoraService;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraApi {

	@Autowired
	private CalculadoraService calculadoraService;

	@GetMapping("/somar/{arg1}/{arg2}")
	public ResponseEntity<Long> somar(@PathVariable("arg1") Long arg1, @PathVariable("arg2") Long arg2) {
		return ResponseEntity.ok(calculadoraService.somar(arg1, arg2));
	}

	@GetMapping("/subtrair/{arg1}/{arg2}")
	public ResponseEntity<Long> subtrair(@PathVariable("arg1") Long arg1, @PathVariable("arg2") Long arg2) {
		return ResponseEntity.ok(calculadoraService.subtrair(arg1, arg2));
	}

	@GetMapping("/multiplicar/{arg1}/{arg2}")
	public ResponseEntity<Long> multiplicar(@PathVariable("arg1") Long arg1, @PathVariable("arg2") Long arg2) {
		return ResponseEntity.ok(calculadoraService.multiplicar(arg1, arg2));
	}

	@GetMapping("/dividir/{arg1}/{arg2}")
	public ResponseEntity<Long> dividir(@PathVariable("arg1") Long arg1, @PathVariable("arg2") Long arg2) {
		return ResponseEntity.ok(calculadoraService.dividir(arg1, arg2));
	}

}
