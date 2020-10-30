package com.unit.lojaunit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unit.lojaunit.model.Marca;
import com.unit.lojaunit.repository.MarcaRepository;

@Controller
@RequestMapping(path="/marca")
public class MarcaController {
	@Autowired
	private MarcaRepository rep;
	
	@PostMapping(path="/add")
	public @ResponseBody String addMarca (@RequestParam String nome, @RequestParam String email, @RequestParam String descricao) {
		Marca entity = new Marca();
		entity.setNome(nome);
		entity.setDescricao(descricao);
		rep.save(entity);
		return "Dados salvos com sucesso";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Marca> getAll(){
		return rep.findAll();
	}
}
