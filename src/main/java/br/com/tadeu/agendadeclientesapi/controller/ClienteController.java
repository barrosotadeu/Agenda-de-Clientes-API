package br.com.tadeu.agendadeclientesapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.tadeu.agendadeclientesapi.dto.DadosAtualizaCliente;
import br.com.tadeu.agendadeclientesapi.dto.DadosCadastraCliente;
import br.com.tadeu.agendadeclientesapi.dto.DadosDetalhamentoCliente;
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
	public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastraCliente dados, UriComponentsBuilder uriBuilder) {
		Cliente cliente = new Cliente(dados);
		this.repository.save(cliente);
		
		var uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
		
		return ResponseEntity.created(uri).body(cliente);
		
	}
	
	@GetMapping
	public ResponseEntity lista(){
			
		List<DadosListagemCliente> lista= this.repository.findAll().stream().map(DadosListagemCliente::new).toList();
		return ResponseEntity.ok(lista);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity atualiza(@PathVariable Long id, @RequestBody @Valid  DadosAtualizaCliente dados) {
		var cliente = this.repository.getReferenceById(id);
		cliente.atualizar(dados);
		
		return ResponseEntity.ok(new DadosDetalhamentoCliente(cliente));
		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity excluir(@PathVariable Long id) {
		this.repository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}

}
