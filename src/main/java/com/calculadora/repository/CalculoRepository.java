package com.calculadora.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.calculadora.model.Calculo;

@Repository
public interface CalculoRepository extends CrudRepository<Calculo, String>{

}
