CREATE TABLE if not EXISTS utenti(
    id int primary key auto_increment,
    nome varchar(50),
    email varchar(50) unique
);