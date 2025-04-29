CREATE DATABASE IF NOT EXISTS db_a3;

USE db_a3;

DROP TABLE IF EXISTS tb_amigos;
DROP TABLE IF EXISTS tb_ferramentas;
DROP TABLE IF EXISTS tb_emprestimos;


# criando a tabela dos amigos
CREATE TABLE tb_amigos (
    IdAmigo INTEGER NOT NULL,
    NomeAmigo VARCHAR(100) NULL,
    TelefoneAmigo INTEGER NULL,
    EmailAmigo VARCHAR(100),
    PRIMARY KEY(IdAmigo)
);

# criando tabela das ferramentas
CREATE TABLE tb_ferramentas (
    IdFerramentas INTEGER NOT NULL,
    NomeFerramentas VARCHAR(100) NULL,
    MarcaFerramentas VARCHAR(100) NULL,
    CustoFerramentas DOUBLE,
    PRIMARY KEY(IdFerramentas)
);

# criando tabela dos emprestimos 
CREATE TABLE tb_emprestimos (
    IdEmprestimo INTEGER NOT NULL,
    IdAmigo INTEGER NULL ,
    IdFerramentas INTEGER NULL ,
    DataEmprestimo DATE NULL,
    DataDevolucao DATE NULL,
    PRIMARY KEY(IdEmprestimo)
);


# inserindo amigos na BD
INSERT INTO tb_amigos(IdAmigo,NomeAmigo,TelefoneAmigo,EmailAmigo) VALUES (1,"Mateus","123456789","emaildomateus@gmail.com");
INSERT INTO tb_amigos(IdAmigo,NomeAmigo,TelefoneAmigo,EmailAmigo) VALUES (2,"Maria","987654321","emaildamaria@gmail.com");

# inserindo ferramentas na BD
INSERT INTO tb_ferramentas(IdFerramentas,NomeFerramentas,MarcaFerramentas,CustoFerramentas) VALUES (1,"Cortador de Grama","Tramontina","199.99");
INSERT INTO tb_ferramentas(IdFerramentas,NomeFerramentas,MarcaFerramentas,CustoFerramentas) VALUES (2,"Martelo","Vonder","59.99");

# inserindo emprestimos na BD
INSERT INTO tb_emprestimos(IdEmprestimo,IdAmigo,IdFerramentas,DataEmprestimo) VALUES (1,1,2,"2024-06-08");
INSERT INTO tb_emprestimos(IdEmprestimo,IdAmigo,IdFerramentas,DataEmprestimo) VALUES (2,2,1,"2024-06-08");
