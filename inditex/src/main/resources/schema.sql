
create table users(
    cod_usr INTEGER AUTO_INCREMENT PRIMARY KEY,
    des_name_usr varchar(10),
    des_surname_usr varchar(20)
);
--COMMENT ON TABLE users IS 'tabla user .';


create table IF NOT EXISTS product (
    cod_product INTEGER AUTO_INCREMENT PRIMARY KEY,         -- Identificador único para cada producto
    des_name VARCHAR(20) NOT NULL,                          -- Nombre del producto
    des_description VARCHAR(80) NOT NULL                   -- Descripción del producto (opcional)

);

create table IF NOT EXISTS brand (
    cod_brand INTEGER AUTO_INCREMENT PRIMARY KEY,      -- Identificador único para cada marca
    des_name VARCHAR(20) NOT NULL,     -- Nombre de la marca
    des_description VARCHAR(80) NOT NULL               -- Descripción de la marca (opcional)
);

create table IF NOT EXISTS prices(
    cod_price INTEGER AUTO_INCREMENT PRIMARY KEY,       -- Identificador único para cada registro de la tabla
    cod_product INTEGER NOT NULL,                       -- fk que se define automáticamente al crear un nuevo registro
    cod_brand INTEGER NOT NULL,                         -- fk que se define automáticamente al crear un nuevo registro
    start_date timestamp without time zone NOT NULL,                           -- Fecha de inicio de la aplicación de la tarifa
    end_date timestamp without time zone NOT NULL,                             -- Fecha de fin de la aplicación de la tarifa
    priority INTEGER  NOT NULL,                         -- Tarifa a aplicar
    price_list INTEGER NOT NULL,                        -- Identificador de la tarifa de precios
    price_final varchar(40) NOT NULL,                   -- Precio final de venta en STRING en vez de DOUBLE
    moneda varchar(5),                                  -- Código ISO de la moneda

    constraint rproduct_prices_1 foreign key (cod_product)
        references product(cod_product),
    constraint rbrand_prices_1 foreign key (cod_brand)
            references brand(cod_brand)
--    constraint unique_price UNIQUE (cod_product, cod_brand, start_date),

);

