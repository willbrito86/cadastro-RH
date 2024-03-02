package com.rhwill.cadastrorh.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rhwill.cadastrorh.entities.Usuario;
import com.rhwill.cadastrorh.repositories.UsuarioRepository;

@RestController
@RequestMapping(value ="/usuario")
public class UsuarioController {
	
	//mecanismo de injeção de dependencia, para evitar instanciar o objeto
	@Autowired
	private UsuarioRepository repository;
	
	
	// essa anotation informa o verbo HTTP será o Get
	@GetMapping
	public List<Usuario> findAll() {
		List<Usuario> result = repository.findAll();
		return result;		
	}
	
	// endpoint para buscar no Banco de dados por ID, falta fazer o tratamento de exceção
	@GetMapping(value = "/{id}")
	public Usuario findById(@PathVariable Long id) {
		Usuario result = repository.findById(id).get();
		return result;		
	}
	
	// endpoint para salvar novo usuario
	@PostMapping
	public Usuario insert(@RequestBody Usuario usuario) {
		Usuario result = repository.save(usuario);
		return result;		
	}
	
	
}
