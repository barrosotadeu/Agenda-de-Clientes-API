package br.com.tadeu.agendadeclientesapi.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastraCliente(
		@NotBlank
		String nome,
		@NotBlank
		@Pattern(regexp="\\d{11}")
		String cpf,
		@NotBlank
		String telefone,
		@NotBlank
		String email,
		
		@NotNull
		@Valid
		DadosEndereco endereco
		
		) {

}
