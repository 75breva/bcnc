
create table IF NOT EXISTS users(
    cod_usr INTEGER AUTO_INCREMENT PRIMARY KEY,
    des_name_usr varchar(10),
    des_surname_usr varchar(20)
);
--COMMENT ON TABLE users IS 'tabla user .';

--SET @maxapp = 20;
--CREATE SEQUENCE IF NOT EXISTS htes.qusers0
--INCREMENT 1
--MINVALUE 1
--START @maxapp;
