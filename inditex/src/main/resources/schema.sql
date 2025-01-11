

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
-- ESTO LO EJECUTO en ADMINER para crear la bbdd. -> http://localhost:9090/?pgsql=postgres&username=admin&db=bcnc&ns=bcnc

-- ESQUEMA BCNC

--create schema if not exists bcnc;
--CREATE TABLE IF NOT EXISTS bcnc.product (
--    cod_product SERIAL PRIMARY KEY,      -- Autoincremental en PostgreSQL
--    des_name VARCHAR(20) NOT NULL,
--    des_description VARCHAR(80) NOT NULL
--);
--
--CREATE TABLE IF NOT EXISTS bcnc.brand (
--    cod_brand SERIAL PRIMARY KEY,        -- Autoincremental en PostgreSQL
--    des_name VARCHAR(20) NOT NULL,
--    des_description VARCHAR(80) NOT NULL
--);
--
--CREATE TABLE IF NOT EXISTS bcnc.prices (
--    cod_price SERIAL PRIMARY KEY,        -- Autoincremental en PostgreSQL
--    cod_product INTEGER NOT NULL,
--    cod_brand INTEGER NOT NULL,
--    start_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
--    end_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
--    priority INTEGER NOT NULL,
--    price_list INTEGER NOT NULL,
--    price_final varchar(40) NOT NULL,
--    moneda VARCHAR(5) NOT NULL,
--
--    CONSTRAINT rproduct_prices_1 FOREIGN KEY (cod_product)
--        REFERENCES bcnc.product(cod_product),
--    CONSTRAINT rbrand_prices_1 FOREIGN KEY (cod_brand)
--        REFERENCES bcnc.brand(cod_brand),
--    CONSTRAINT unique_price UNIQUE (cod_product, cod_brand, start_date) -- Se añade la restricción unique
--);
--
--create sequence if not exists bcnc.qbcncpro0
--increment 1
--minvalue 1
--start 1;
--
--create sequence if not exists bcnc.qbcncbra0
--increment 1
--minvalue 1
--start 1;
--
--create sequence if not exists bcnc.qbcncpri0
--increment 1
--minvalue 1
--start 1;





-- ESQUEMA POR DEFECTO ES PUBLIC




--CREATE TABLE IF NOT EXISTS product (
--    cod_product SERIAL PRIMARY KEY,      -- Autoincremental en PostgreSQL
--    des_name VARCHAR(20) NOT NULL,
--    des_description VARCHAR(80) NOT NULL
--);
--
--CREATE TABLE IF NOT EXISTS brand (
--    cod_brand SERIAL PRIMARY KEY,        -- Autoincremental en PostgreSQL
--    des_name VARCHAR(20) NOT NULL,
--    des_description VARCHAR(80) NOT NULL
--);
--
--CREATE TABLE IF NOT EXISTS prices (
--    cod_price SERIAL PRIMARY KEY,        -- Autoincremental en PostgreSQL
--    cod_product INTEGER NOT NULL,
--    cod_brand INTEGER NOT NULL,
--    start_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
--    end_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
--    priority INTEGER NOT NULL,
--    price_list INTEGER NOT NULL,
--    price_final varchar(40) NOT NULL,
--    moneda VARCHAR(5) NOT NULL,
--
--    CONSTRAINT rproduct_prices_1 FOREIGN KEY (cod_product)
--        REFERENCES bcnc.product(cod_product),
--    CONSTRAINT rbrand_prices_1 FOREIGN KEY (cod_brand)
--        REFERENCES bcnc.brand(cod_brand),
--    CONSTRAINT unique_price UNIQUE (cod_product, cod_brand, start_date) -- Se añade la restricción unique
--);
--
--
--
--create sequence if not exists qbcncpro0
--increment 1
--minvalue 1
--start 1;
--
--create sequence if not exists qbcncbra0
--increment 1
--minvalue 1
--start 1;
--
--create sequence if not exists qbcncpri0
--increment 1
--minvalue 1
--start 1;

