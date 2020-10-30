package com.unit.lojaunit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unit.lojaunit.model.Produto;
import com.unit.lojaunit.repository.ProdutoRepository;

@Controller
@RequestMapping(path="/produto")
public class ProdutoController {
	@Autowired
	private ProdutoRepository rep;
	
	@PostMapping(path="/add")
	public @ResponseBody String addProduto (@RequestParam String nome, @RequestParam String descricao, @RequestParam String cpf) {
		Produto entity = new Produto();
		entity.setNome(nome);
		entity.setDescricao(descricao);
		rep.save(entity);
		return "Dados salvos com sucesso";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Produto> getAll(){
		return rep.findAll();
	}
}
