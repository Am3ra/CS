CREATE DATABASE hospital;
use hospital;
CREATE TABLE medico (
`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nombre varchar
(9) not null,
departamento varchar
(9) not null,
especialidad varchar
(15) not null
);
CREATE TABLE paciente (
`folio` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nombre varchar
(9) not null,
);
CREATE TABLE examen (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    fecha date not null,
    tipo varchar
    (9) not null,
    FOREIGN KEY
    (id_doc)
    REFERENCES medico
    (id),
    FOREIGN KEY
    (id_paciente)
    REFERENCES paciente
    (folio)
);

CREATE TABLE atiende
(
    id_doc varchar(15) not null,
    diagnostico varchar(15) not null,
    folio varchar(15) not NULL,
    FOREIGN KEY
    (id_paciente)
    REFERENCES paciente
    (folio),
    FOREIGN KEY
    (id_doc)
    REFERENCES medico
    (id)
);








