/*query multads*/
DROP TABLE IF EXISTS pessoa;
DROP TABLE IF EXISTS perfilpermissao;
DROP TABLE IF EXISTS permissao;
DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS perfil;
DROP TABLE IF EXISTS pagamento;
DROP TABLE IF EXISTS multa;
DROP TABLE IF EXISTS infracao;
DROP TABLE IF EXISTS tipoinfracao;
DROP TABLE IF EXISTS pontuacaoveiculo;

CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
    login VARCHAR(150),
    tipoperfil SERIAL,
    senha VARCHAR(150),
    UNIQUE(login)
);

CREATE TABLE perfilpermissao (
    id SERIAL PRIMARY KEY,
    idpermissao SERIAL,
    idperfil SERIAL
);

CREATE TABLE permissao (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(150)
);

CREATE TABLE perfil (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(150),
    descricao VARCHAR(150)
);

CREATE TABLE pessoa (
	id SERIAL PRIMARY KEY UNIQUE,
	documento varchar(15) UNIQUE,
	nome varchar(50),
	email varchar(100) UNIQUE,
	idusuario SERIAL
);

CREATE TABLE multa(
	id SERIAL PRIMARY KEY UNIQUE,
	renavam varchar(30),
	documento varchar(15),
	datamulta timestamp,
	descricao varchar(4000),
	idinfracao SERIAL	
);

CREATE TABLE pagamento(
	id SERIAL PRIMARY KEY UNIQUE,
	datapagamento timestamp,
	atrasodias integer,
	valor float,
	idmulta SERIAL
);

CREATE TABLE pontuacaoveiculo(
	id SERIAL PRIMARY KEY UNIQUE,
	renavam varchar(30),
	pontuacao integer,
	dataultima timestamp
);

CREATE TABLE infracao(
	id SERIAL PRIMARY KEY UNIQUE,
	descricao varchar(4000),
	idtipo SERIAL
);

CREATE TABLE tipoinfracao(
	id SERIAL PRIMARY KEY UNIQUE,
	descricao varchar(4000),
	pontuacao integer,
	valor float,
	UNIQUE(descricao,pontuacao)
);

ALTER TABLE pessoa ADD CONSTRAINT FK_pessoa_1
    FOREIGN KEY (idusuario)
    REFERENCES usuario (id);
	
ALTER TABLE usuario ADD CONSTRAINT FK_usuario_1
    FOREIGN KEY (tipoperfil)
    REFERENCES perfil (id);
 
ALTER TABLE perfilpermissao ADD CONSTRAINT FK_perfilpermissao_1
    FOREIGN KEY (idpermissao)
    REFERENCES permissao (id);
 
ALTER TABLE perfilpermissao ADD CONSTRAINT FK_perfilpermissao_2
    FOREIGN KEY (idperfil)
    REFERENCES perfil (id);
	
ALTER TABLE multa ADD CONSTRAINT FK_multa_1
    FOREIGN KEY (idinfracao)
    REFERENCES infracao (id);
	
ALTER TABLE infracao ADD CONSTRAINT FK_infracao_1
    FOREIGN KEY (idTipo)
    REFERENCES tipoinfracao (id);
	
ALTER TABLE pagamento ADD CONSTRAINT FK_pagamento_1
    FOREIGN KEY (idmulta)
    REFERENCES multa (id);
	
	
insert into pontuacaoveiculo (renavam,pontuacao,dataultima) values 
('44609582799',7,'20200701 10:34:09 AM'),
('67816544599',5,'20200702 10:34:09 AM'),
('02792712299',3,'20200703 10:34:09 AM'),
('92651193699',1,'20200704 10:34:09 AM'),
('12836031499',7,'20200705 10:34:09 AM'),
('80357878299',5,'20200706 10:34:09 AM'),
('31209155899',3,'20200707 10:34:09 AM');

insert into tipoinfracao(descricao,pontuacao,valor) values
('Gravissima',7,293.00),
('Grave',5,195.23),
('Media',3,130.16),
('Leve',1,88.38);

insert into infracao(descricao,idtipo) values
('conduzir sem possuir CNH ou com  documento suspenso',1),
('Conduzir veículo de categoria diferente da que a pessoa está habilitada',1),
('Dirigir após consumir bebida alcoólica ou drogas',1),
('Não usar cinco de segurança, válido para todos os ocupantes do veículo;',2),
('Deixar de prestar socorro a vítima de trânsito quando solicitado;',2),
('Estacionar a mais de um metro do meio-fio;',2),
('Parar o veículo em um cruzamento;',3),
('Parar o veículo em viadutos, pontes ou túneis;',3),
('Utilizar o veículo para jogar água nos pedestres;',3),
('Dirigir sem estar com a CNH ou documento do veículo;',4),
('Estacionar na calçada ou na faixa de pedestre;',4),
('Estacionar no acostamento;',4);



insert into multa(renavam,documento,datamulta,descricao,idinfracao) values
('44609582799','29359062240','20200701 10:34:09 AM','descricao1',1),
('67816544599','87585785339','20200702 10:34:09 AM','descricao2',4),
('02792712299','03759909954','20200703 10:34:09 AM','descricao3',8),
('92651193699','62743618858','20200704 10:34:09 AM','descricao4',12),
('12836031499','66651836977','20200705 10:34:09 AM','descricao5',2),
('80357878299','66651836977','20200706 10:34:09 AM','descricao6',5),
('31209155899','23116639390','20200707 10:34:09 AM','descricao7',9),

('66752741999','60806789850','20200708 10:34:09 AM','descricao8',1),
('04361240399','06792335207','20200709 10:34:09 AM','descricao9',4),
('54944522699','70179153872','20200710 10:34:09 AM','descricao10',7),
('46414579599','66651836977','20200711 10:34:09 AM','descricao11',10),
('50228117499','54456370568','20200712 10:34:09 AM','descricao12',12);

insert into pagamento (datapagamento,atrasodias,valor,idmulta) values
('20200808 13:34:09',31,351.6,8),
('20200709 14:34:09',0,195.23,9),
('20200710 15:34:09',0,130.16,10),
('20200712 16:34:09',1,88.38,11),
('20200714 17:34:09',2,88.38,12);

insert into permissao (descricao) values
('ISADMIN'),
('READ_EMPLOYEE'),
('WRITE_EMPLOYEE'),
('READ_SOMETHING'),
('WRITE_SOMETHING'),
('READ_SOMETIMES');


insert into perfil (nome,descricao) values 
('ADMINISTRADOR','ADMINISTRADOR'),
('POLICIAL','PULISSA'),
('CONDUTOR','CONDUTOR');

insert into perfilpermissao (idperfil,idpermissao)values 
(1,1),(1,2),(1,3),(1,4),(1,5),(1,6),
(2,2),(2,3),(2,4),(2,5),(2,6),
(3,4),(3,5),(3,6);

insert into usuario(login,tipoperfil,senha)values
('condutor1',3,'condutor1'),
('condutor2',3,'condutor2'),
('condutor3',3,'condutor3'),
('condutor4',3,'condutor4'),
('condutor5',3,'condutor5'),
('condutor6',3,'condutor6'),
('condutor7',3,'condutor7'),
('condutor8',3,'condutor8'),
('condutor9',3,'condutor9'),
('condutor10',3,'condutor10'),
('policial1',2,'policial1'),
('policial2',2,'policial2'),
('policial3',2,'policial3'),
('admin',1,'admin');


insert into pessoa (documento,nome,email,idusuario) values
('29359062240','Christen','nibh.vulputate@ametdiameu.co.uk',1),
('87585785339','Kathleen','accumsan@nec.org',2),
('03759909954','Paul','commodo.hendrerit.Donec@ligulaAeneangravida.edu',3),
('62743618858','Kylynn','auctor.nunc.nulla@ipsumdolor.org',4),
('66651836977','Isaiah','tempus@ultricesposuerecubilia.co.uk',5),
('23116639390','Alexis','odio.Nam@lobortisrisusIn.org',6),
('60806789850','Melyssa','tellus@justo.org',7),
('06792335207','Bianca','tincidunt.dui@antelectus.edu',8),
('70179153872','Lyle','vulputate@consectetuer.com',9),
('54456370568','Uriah','dapibus.rutrum.justo@malesuadaid.org',10),
('11122233344','Policial1','policial1@gmail.com',11),
('22233344455','Policial2','policial2@gmail.com',12),
('33344455566','Policial3','policial3@gmail.com',13),
('11111111111','Administrador','admin@admin.com',14);
