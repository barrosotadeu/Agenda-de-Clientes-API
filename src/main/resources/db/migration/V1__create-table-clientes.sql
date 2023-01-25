create table clientes(

	id bigint not null auto_increment,
	nome varchar(100) not null,
	cpf varchar(11) not null,
	telefone varchar(20) not null,
	email varchar(50) not null,
	cep varchar(8) not null,
	logradouro varchar(100) not null,
	complemento varchar(100),
	bairro varchar(20) not null,
	cidade varchar(20) not null,
	uf varchar (2) not null,
	
	primary key(id)
		)