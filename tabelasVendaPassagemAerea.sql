CREATE TABLE cliente(idCliente serial PRIMARY KEY,nome varchar(30),
rg varchar(10), telefone varchar(14));

CREATE TABLE aviao(idAviao serial PRIMARY KEY, codigo int, nome varchar(30),
qtdeAssentos int);

CREATE TABLE voo(idVoo serial PRIMARY KEY, origem varchar(30), 
destino varchar(30),dataVoo Date,idAviao int references aviao(idAviao));

CREATE TABLE ASSENTOS(idAssento serial PRIMARY KEY,
idVoo int references voo(idVoo), 
disponibilidade boolean,numAssento int);


select * from cliente;
select * from aviao;
select * from voo;
select * from assentos;

delete  from voo WHERE idVoo = 5;
drop table voo;