create schema if not exists bcnc;

CREATE TABLE IF NOT EXISTS bcnc.product (
    cod_product INTEGER AUTO_INCREMENT PRIMARY KEY,     -- Autoincremental en PostgreSQL
    des_name VARCHAR(20) NOT NULL,
    des_description VARCHAR(80) NOT NULL
);

CREATE TABLE IF NOT EXISTS bcnc.brand (
    cod_brand INTEGER AUTO_INCREMENT PRIMARY KEY,        -- Autoincremental en PostgreSQL
    des_name VARCHAR(20) NOT NULL,
    des_description VARCHAR(80) NOT NULL
);

CREATE TABLE IF NOT EXISTS bcnc.prices (
    cod_price INTEGER AUTO_INCREMENT PRIMARY KEY,        -- Autoincremental en PostgreSQL
    cod_product INTEGER NOT NULL,
    cod_brand INTEGER NOT NULL,
    start_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    end_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    priority INTEGER NOT NULL,
    price_list INTEGER NOT NULL,
    price_final varchar(40) NOT NULL,
    moneda VARCHAR(5) NOT NULL,

    CONSTRAINT rproduct_prices_1 FOREIGN KEY (cod_product)
        REFERENCES bcnc.product(cod_product),
    CONSTRAINT rbrand_prices_1 FOREIGN KEY (cod_brand)
        REFERENCES bcnc.brand(cod_brand),
    CONSTRAINT unique_price UNIQUE (cod_product, cod_brand, start_date) -- Se añade la restricción unique
);


-- sequences
--set @maxapp = 20;
--create sequence if not exists bcnc.qbcncpro0
--increment 1
--minvalue 1
--start @maxapp;
--
--create sequence if not exists bcnc.qbcncbra0
--increment 1
--minvalue 1
--start @maxapp;
--
--create sequence if not exists bcnc.qbcncpri0
--increment 1
--minvalue 1
--start @maxapp;