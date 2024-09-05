drop database if exists library;
create database library;
use library;

create table book(
codigo int auto_increment primary key,
title varchar(50),
author varchar(50),
ano int,
genre VARCHAR(30),
editora VARCHAR(50)
);

//page2
use library;

INSERT INTO book (title, author, ano, genre, editora) 
VALUES ('Lovecraft', 'Lovecraft', 2018, 'Terror', 'Darkside Books');
INSERT INTO book (title, author, ano, genre, editora) 
VALUES ('Codigo da Vinci', 'Dan Brown', 2006, 'Suspense', 'Sextante');
INSERT INTO book (title, author, ano, genre, editora) 
VALUES ('Divina Comedia', 'Dante Alighieri', 2011, 'Clássico', 'Principis');
INSERT INTO book (title, author, ano, genre, editora) 
VALUES ('Guerra Mundial Z', 'Max Brooks', 2006, 'Ficção Científica', 'Rocco');
