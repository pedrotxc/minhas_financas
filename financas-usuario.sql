mysql
create table financas.usuario (
    id bigint not null auto_increment,
    nome varchar(150),
    email varchar(100),
    senha varchar(20),
    data_cadastro datetime default NOW(),
    PRIMARY KEY(id)
);

postgres
CREATE TABLE financas.usuario (
    id bigserial NOT NULL PRIMARY KEY,
    nome character varying(150),
    email character varying(100),
    senha character varying(20),
    data_cadastro date DEFAULT NOW()
)