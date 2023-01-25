package br.com.tadeu.agendadeclientesapi.model;

import br.com.tadeu.agendadeclientesapi.dto.DadosAtualizaCliente;
import br.com.tadeu.agendadeclientesapi.dto.DadosCadastraCliente;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
@Getter
@Entity
@Table(name = "clientes")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	@Embedded
	private Endereco endereco;
	
	
	public Cliente(DadosCadastraCliente dados) {
		this.nome = dados.nome();
		this.cpf = dados.cpf();
		this.telefone = dados.telefone();
		this.email = dados.email();
		this.endereco = new Endereco(dados.endereco());
	}
	
	public void atualizar(DadosAtualizaCliente dados) {
		this.nome = dados.nome();
		this.cpf = dados.cpf();		
		this.telefone = dados.telefone();
		this.email = dados.email();
		this.endereco = new Endereco(dados.endereco());
	}

}
