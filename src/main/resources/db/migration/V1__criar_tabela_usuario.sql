create table financas.usuario (
    id bigint not null auto_increment,
    nome varchar(150),
    email varchar(100),
    senha varchar(20),
    data_cadastro datetime default NOW(),
    PRIMARY KEY(id)
);