INSERT INTO users (des_name_usr,des_surname_usr) VALUES
('Miguel', 'Arredondo Calderon'),
('David', 'Arredondo Calderon');

INSERT INTO product (cod_product,des_name, des_description) VALUES
(35455,'Product 35455', 'Producto con ID 35455 para pruebas de tarifas.');  -- Solo un producto para el ejemplo

INSERT INTO brand (cod_brand,des_name, des_description) VALUES
(1,'Zara ', 'Marca zara de ejemplo para los precios.'),
(2,'Pull&Bear', 'Marca Pull&Bear de ejemplo para los precios.');

INSERT INTO prices (cod_price,cod_product, cod_brand, start_date, end_date, priority, price_list, price_final, moneda) VALUES
(1,35455, 1, '2024-06-10 00:00:00', '2024-12-31 23:59:59', 1, 1, '35.50', 'EUR'),
(2,35455, 1, '2024-06-11 15:00:00', '2024-06-20 18:30:00', 2, 1, '25.45', 'EUR'),
(3,35455, 1, '2024-06-15 00:00:00', '2024-06-15 11:00:00', 3, 1, '30.50', 'EUR'),
(4,35455, 1, '2024-06-20 16:00:00', '2024-12-31 23:59:59', 4, 1, '38.95', 'EUR');


