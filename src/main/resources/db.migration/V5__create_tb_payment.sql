CREATE TABLE tb_order_item (
   id_pay INT AUTO_INCREMENT PRIMARY KEY,
   id_order INT NOT NULL,
   qr_code varchar(20),
   status varchar(20) not null,
   pay_value DECIMAL(10, 2),
   creation_pay timestamp default CURRENT_TIMESTAMP(),
   last_update_pay timestamp default CURRENT_TIMESTAMP(),
   FOREIGN KEY (id_order) REFERENCES tb_order(id_order)
);