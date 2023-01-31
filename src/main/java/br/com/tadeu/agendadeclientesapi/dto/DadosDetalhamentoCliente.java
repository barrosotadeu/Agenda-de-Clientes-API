package br.com.tadeu.agendadeclientesapi.dto;

import br.com.tadeu.agendadeclientesapi.model.Cliente;
import br.com.tadeu.agendadeclientesapi.model.Endereco;

public record DadosDetalhamentoCliente(Long id, String nome, String cpf, String telefone, String email, Endereco endereco) {
	
	public DadosDetalhamentoCliente(Cliente cliente) {
		this(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getTelefone(), cliente.getEmail(), cliente.getEndereco());
	}
}
