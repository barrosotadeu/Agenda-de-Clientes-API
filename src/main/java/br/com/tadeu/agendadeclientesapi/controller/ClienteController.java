package br.com.tadeu.agendadeclientesapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tadeu.agendadeclientesapi.dto.DadosAtualizaCliente;
import br.com.tadeu.agendadeclientesapi.dto.DadosCadastraCliente;
import br.com.tadeu.agendadeclientesapi.dto.DadosListagemCliente;
import br.com.tadeu.agendadeclientesapi.model.Cliente;
import br.com.tadeu.agendadeclientesapi.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("clientes")
@Transactional
public class ClienteController {
	
	@Autowired
	private ClienteRepository repository;
	
	@PostMapping
	public void cadastrar(@RequestBody @Valid DadosCadastraCliente dados) {
		Cliente cliente = new Cliente(dados);
		this.repository.save(cliente);
	}
	
	@GetMapping
	public List<DadosListagemCliente> lista(){
			
		return this.repository.findAll().stream().map(DadosListagemCliente::new).toList();
		
	}
	
	@PutMapping("/{id}")
	public void atualiza(@PathVariable Long id, @RequestBody @Valid  DadosAtualizaCliente dados) {
		var cliente = this.repository.getReferenceById(id);
		cliente.atualizar(dados);
		
	}
	
	@DeleteMapping("/{id}")
	public void exluir(@PathVariable Long id) {
		this.repository.deleteById(id);
	}

}
