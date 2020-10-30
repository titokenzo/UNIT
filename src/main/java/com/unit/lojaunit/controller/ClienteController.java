package com.unit.lojaunit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unit.lojaunit.model.Cliente;
import com.unit.lojaunit.repository.ClienteRepository;

@Controller
@RequestMapping(path="/cliente")
public class ClienteController {
	@Autowired
	private ClienteRepository rep;
	
	@PostMapping(path="/add")
	public @ResponseBody String addCliente (@RequestParam String nome, @RequestParam String email, @RequestParam String cpf) {
		Cliente entity = new Cliente();
		entity.setNome(nome);
		entity.setCpf(cpf);
		entity.setEmail(email);
		rep.save(entity);
		return "Dados salvos com sucesso";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Cliente> getAll(){
		return rep.findAll();
	}
}
