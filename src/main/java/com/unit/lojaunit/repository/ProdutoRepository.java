package com.unit.lojaunit.repository;

import org.springframework.data.repository.CrudRepository; 

import com.unit.lojaunit.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

}
