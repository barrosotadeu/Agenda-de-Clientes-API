package br.com.tadeu.agendadeclientesapi.model;

import br.com.tadeu.agendadeclientesapi.dto.DadosEndereco;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor

public class Endereco {
	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	
	public Endereco(DadosEndereco dados) {
		this.cep = dados.cep();
		this.logradouro = dados.logradouro();
		this.complemento = dados.complemento();
		this.bairro = dados.bairro();
		this.cidade = dados.cidade();
		this.uf = dados.uf();
	}

	

	public Endereco(String cep, String logradouro, String complemento, String bairro, String cidade, String uf) {
		super();
		this.cep = cep;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
	}
	
	@Override
	public String toString() {
		
		return "cep: " + this.cep +
			   " Logradouro: " + this.logradouro + 
			   " Complemento: " + this.complemento +
			   " Bairro: " + this.bairro + 
			   " Cidade: " + this.cidade +
			   "uf: " + this.uf;
	}
}
