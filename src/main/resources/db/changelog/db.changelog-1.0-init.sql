--liquibase formatted sql

--changeset aleksokol3:1
CREATE TABLE IF NOT EXISTS employee(
    id BIGINT AUTO_INCREMENT PRIMARY KEY ,
    first_name VARCHAR(64) NOT NULL ,
    last_name VARCHAR(64) NOT NULL ,
    age INT NOT NULL CHECK (age >= 18) ,
    salary NUMERIC(10,2) NOT NULL CHECK (salary > 0) ,
    hiring_date TIMESTAMP NOT NULL
);