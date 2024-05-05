
create table tb_cliente
(
    co_seq_cliente           int auto_increment
        primary key,
    no_cliente               varchar(100) not null,
    nu_cpf                   varchar(11)  not null,
    dt_criado                datetime(6)  not null,
    dt_modificado            datetime(6)  null,
    no_responsavel_cadastro  varchar(45)  not null,
    no_responsavel_alteracao varchar(45)  not null,
    constraint tb_cliente_nu_cpf_uindex
        unique (nu_cpf)
);

create table tb_email
(
    co_seq_email int auto_increment
        primary key,
    ds_email     varchar(150) not null,
    co_cliente   int          not null,
    constraint tb_email_ds_email_uindex
        unique (ds_email),
    constraint tb_email_tb_cliente_co_seq_cliente_fk
        foreign key (co_cliente) references tb_cliente (co_seq_cliente)
);

create table tb_endereco
(
    co_seq_endereco int auto_increment
        primary key,
    nu_cep          int          not null,
    ds_logradouro   varchar(100) not null,
    no_bairro       varchar(100) not null,
    no_cidade       varchar(100) not null,
    co_uf           varchar(2)   not null,
    ds_complemento  varchar(45)  null,
    co_cliente      int          not null,
    constraint tb_endereco_tb_cliente_co_seq_cliente_fk
        foreign key (co_cliente) references tb_cliente (co_seq_cliente)
);


create table tb_telefone
(
    co_seq_telefone  int auto_increment
        primary key,
    nu_telefone      varchar(15) not null,
    co_tipo_telefone tinyint(1)  not null,
    co_cliente       int         not null,
    constraint tb_telefone_tb_cliente_co_seq_cliente_fk
        foreign key (co_cliente) references tb_cliente (co_seq_cliente)
);

create table tb_usuario
(
    co_seq_usuario int auto_increment
        primary key,
    nm_usuario     varchar(100)      not null,
    ds_email       varchar(45)       not null,
    ds_senha       varchar(255)      not null,
    st_ativo       tinyint default 1 not null,
    co_perfil      int               not null,
    ds_login       varchar(45)       not null,
    constraint ds_email_UNIQUE
        unique (ds_email),
    constraint tb_usuario_ds_login_uindex
        unique (ds_login)
);

