CREATE TABLE tb_order_item (
   id_order_item INT AUTO_INCREMENT PRIMARY KEY,
   id_order INT NOT NULL,
   id_product INT NOT NULL,
   quantity INT NOT NULL,
   FOREIGN KEY (id_order) REFERENCES tb_order(id_order),
   FOREIGN KEY (id_product) REFERENCES tb_product(id_product)
);