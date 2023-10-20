create table financas.lancamento (
    id bigint not null auto_increment,
    descricao varchar(100) not null,
    mes int not null,
    ano int not null,
    valor numeric(16,2) not null,
    tipo varchar(20) check (tipo in ('RECEITA' , 'DESPESA')) not null,
    status varchar(20) check (status in ('PENDENTE', 'CANCELADO', 'EFETIVADO')) not null,
    usuario_id bigint not null,
    foreign key (usuario_id) references usuario(id),
    data_cadastro datetime default NOW(),
    PRIMARY KEY(id)
);