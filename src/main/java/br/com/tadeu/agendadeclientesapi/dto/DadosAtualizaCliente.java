package br.com.tadeu.agendadeclientesapi.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizaCliente(
		@NotBlank
		String nome,
		@NotBlank
		String cpf,
		@NotBlank
		String telefone,
		@NotBlank
		String email,
		@NotNull
		@Valid
		DadosEndereco endereco) {

}
