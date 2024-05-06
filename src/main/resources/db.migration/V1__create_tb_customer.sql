create table tb_customer(
    id_customer int primary key auto_increment,
    name varchar(200) not null,
    email varchar(200) not null,
    cpf varchar(200) not null
);