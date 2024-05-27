create table tb_order(
    id_order int primary key auto_increment,
    order_value DECIMAL(10, 2),
    id_customer INT not null,
    creation_order timestamp default CURRENT_TIMESTAMP(),
    last_update_order timestamp default CURRENT_TIMESTAMP(),
    status varchar(20) not null,
    FOREIGN KEY (id_customer) REFERENCES tb_customer(id_customer)
);