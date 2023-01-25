package br.com.tadeu.agendadeclientesapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
		@NotBlank
		@Pattern(regexp="\\d{8}")
		String cep,
		@NotBlank
		String logradouro,
		String complemento,
		@NotBlank
		String bairro,
		@NotBlank
		String cidade,
		@NotBlank
		String uf
		) {

}
