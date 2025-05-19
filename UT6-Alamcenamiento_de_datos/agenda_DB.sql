-- Eliminar si existe
DROP DATABASE IF EXISTS Agenda;

-- Crear la base de datos
CREATE DATABASE Agenda;

-- Usar la base de datos
USE Agenda;

-- Crear la tabla Contactos
CREATE TABLE Contactos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    apellidos VARCHAR(100),
    email VARCHAR(100),
    fecha_nacimiento DATE
);

-- Insertar los contactos del ejemplo
INSERT INTO Contactos (nombre, apellidos, email, fecha_nacimiento) VALUES
('Mortadelo', 'Mortadelo', 'mortadelo@kk.com', STR_TO_DATE('01/01/1900', '%d/%m/%Y')),
('Filemon', 'Filemon', 'filemon@kk.com', STR_TO_DATE('05/01/1900', '%d/%m/%Y')),
('Juan', 'Perez Cano', 'juan@kk.com', STR_TO_DATE('08/11/1979', '%d/%m/%Y')),
('Celia', 'Perez Cano', 'celia@kk.com', STR_TO_DATE('21/01/1986', '%d/%m/%Y'));
