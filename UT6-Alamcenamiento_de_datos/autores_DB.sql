DROP DATABASE IF EXISTS autores;
CREATE DATABASE autores;

USE autores;

CREATE TABLE autores (
    dni VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(50), 
    pais VARCHAR(50),
    edad INT
);

INSERT INTO autores (dni, nombre, pais, edad) VALUES
    ('23230001A','Juan Gomes Jurado','Spain', 38),
    ('48484200A','Juan Cuello Largo','Spain', 43),
    ('11542462F','Pablo Neruda','Chile', 81),
    ('23225483A','Javier Ibarra Muñoz','Peru', 30),
    ('47565134A','Stephen King','USA', 65);
