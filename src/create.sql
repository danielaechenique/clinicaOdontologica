CREATE TABLE IF NOT EXISTS odontologos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    matricula VARCHAR(50) NOT NULL
);
CREATE TABLE IF NOT EXISTS pacientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    apellido VARCHAR(50) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    domicilio VARCHAR(50) NOT NULL,
    dni VARCHAR(50) NOT NULL,
    fechaDeAlta DATE
);


INSERT INTO odontologos (nombre, apellido, matricula) VALUES ('Juan', 'Perez', 'MP123');
INSERT INTO odontologos (nombre, apellido, matricula) VALUES ('Jose', 'Garcia', 'MN321');
INSERT INTO odontologos (nombre, apellido, matricula) VALUES ('Jorge', 'Lopez', 'MP456');
INSERT INTO pacientes (apellido, nombre, domicilio, dni, fechaDeAlta) VALUES ('Juana', 'Pereza', 'maipu 1', '1234');
INSERT INTO pacientes (apellido, nombre, domicilio, dni, fechaDeAlta) VALUES ('Josefa', 'Garciuas', 'maiou 2', '4321');
INSERT INTO pacientes (apellido, nombre, domicilio, dni, fechaDeAlta) VALUES ('Jorjelina', 'Lopezag', 'Mayoi 3', '5678');